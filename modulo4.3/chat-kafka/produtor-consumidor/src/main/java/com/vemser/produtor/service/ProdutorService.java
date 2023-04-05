package com.vemser.produtor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vemser.produtor.dto.MensagemDTO;
import com.vemser.produtor.dto.NomeChat;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProdutorService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value(value = "${kafka.topic}")
    private String topic;

    public void sendTo(MensagemDTO mensagemDTO, NomeChat nome) throws JsonProcessingException {
        String mensagem = objectMapper.writeValueAsString(mensagemDTO);

        MessageBuilder<String> stringMessageBuilder = MessageBuilder.withPayload(mensagem)
                .setHeader(KafkaHeaders.TOPIC,topic)
                .setHeader(KafkaHeaders.MESSAGE_KEY,UUID.randomUUID().toString());

        if (nome != null) {
            stringMessageBuilder
                    .setHeader(KafkaHeaders.PARTITION_ID,nome.getParticao());
        }
            Message<String> message = stringMessageBuilder.build();

            ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(message);
            future.addCallback(new ListenableFutureCallback<>() {
                @Override
                public void onSuccess(SendResult result) {
                    log.info("Log enviado para o kafka contendo o texto: {} ", mensagem);
                }

                @Override
                public void onFailure(Throwable ex) {
                    log.error("Erro ao publicar no kafka com a mensagem: {}", mensagem, ex);
                }
        });
    }
}