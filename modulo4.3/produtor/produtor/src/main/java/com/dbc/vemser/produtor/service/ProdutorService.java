package com.dbc.vemser.produtor.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProdutorService {
    @Value(value = "${kafka.topic}")
    private String topic; //caixa-de-correio
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void enviarMensagemParaOTopico(String mensagem) {
        MessageBuilder<String> stringMessageBuilder = MessageBuilder.withPayload(mensagem)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString());
        // baf1c3f5-888d-4ad3-a6f3-7a133798d4ff

//        kafkaTemplate.send(stringMessageBuilder.build());
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(stringMessageBuilder.build());
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult result) {
                log.info(" Log enviado para o kafka com o texto: {} ", mensagem);
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error(" Erro ao publicar duvida no kafka com a mensagem: {}", mensagem, ex);
            }
        });
    }
}
