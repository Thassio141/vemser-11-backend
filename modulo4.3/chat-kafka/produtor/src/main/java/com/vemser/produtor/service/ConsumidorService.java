package com.vemser.produtor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vemser.produtor.dto.MensagemDTO;
import com.vemser.produtor.dto.NomeChat;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.UUID;
@Service
@RequiredArgsConstructor
@Slf4j
public class ConsumidorService {

    private final ObjectMapper objectMapper;

    @KafkaListener(
            topics = "${kafka.topic}", // passa variavel da properties sem precisar do @Value
            groupId = "${spring.kafka.group-id}",
            topicPartitions = {@TopicPartition(topic = "${kafka.topic}", partitions = {"12"})},
            containerFactory = "listenerContainerFactory1")

    public void consumeGeral1(@Payload String mensagem,
                             @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Long partition)
            throws JsonProcessingException {

        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);
        log.info("Mensagem Recebida: " + mensagemDTO);
    }

    @KafkaListener(
            topics = "${kafka.topic}", // passa variavel da properties sem precisar do @Value
            groupId = "${spring.kafka.group-id}",
            topicPartitions = {@TopicPartition(topic = "${kafka.topic}", partitions = {"12"})},
            containerFactory = "listenerContainerFactory2")

    public void consumeGeral2(@Payload String mensagem,
                             @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Long partition)
            throws JsonProcessingException {

        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);
        log.info("Mensagem Recebida: " + mensagemDTO);
    }
}
