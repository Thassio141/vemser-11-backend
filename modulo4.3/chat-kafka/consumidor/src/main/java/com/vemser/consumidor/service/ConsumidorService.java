package com.vemser.consumidor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vemser.consumidor.dto.MensagemDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumidorService {
    private final ObjectMapper objectMapper;

    private static final String CHAT1 = "ca3xrcl7-chat1";

    @KafkaListener(
            clientIdPrefix = "kaio",
            groupId = "kaio",
            topicPartitions = {@TopicPartition(topic = "${kafka.topic}", partitions = {"0"})}
    )
    public void consumirMensagensPrivadas(@Payload String mensagem,
                                           @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                                           @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition,
                                           @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        MensagemDTO minhaMensagemLida = objectMapper.readValue(mensagem, MensagemDTO.class);
        log.info("####{consumirMensagensPrivadas} offset -> '{}' key -> '{}' -> Consumed Object message -> '{}' partition -> {} ", offset, key, minhaMensagemLida, partition);
    }

    @KafkaListener(
            clientIdPrefix = "kaio2",
            groupId = "kaio2",
            topicPartitions = {@TopicPartition(topic = CHAT1, partitions = {"0"})}
    )
    public void consumirTodasMensagens(@Payload String mensagem,
                                           @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                                           @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition,
                                           @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        MensagemDTO minhaMensagemLida = objectMapper.readValue(mensagem, MensagemDTO.class);
        log.info("####{consumirTodasMensagens} offset -> '{}' key -> '{}' -> Consumed Object message -> '{}' partition -> {} ", offset, key, minhaMensagemLida, partition);
    }
}
