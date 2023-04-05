package com.vemser.produtor.config;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;
@Configuration
public class KafkaConsumerConfig {
    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Value(value = "${spring.kafka.properties.sasl.mechanism}")
    private String saslMechanism;

    @Value(value = "${spring.kafka.properties.sasl.jaas.config}")
    private String jaasConfig;

    @Value(value = "${spring.kafka.properties.security.protocol}")
    private String protocol;

    @Value(value = "${spring.kafka.properties.enable.idempotence}")
    private String idempotence;

    @Value(value="spring.kafka.client-id")
    private String clientId;

    private static final String EARLIEST = "earliest";
    private static final String LATEST = "latest";

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,String> listenerContainerFactory1() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress); // servidor
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class); // chave
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class); // valor
        configProps.put(ConsumerConfig.CLIENT_ID_CONFIG, clientId); // client ID
        configProps.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 10); // quantidade de linhas por vez lida
        configProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, EARLIEST);
        configProps.put("sasl.mechanism", saslMechanism);
        configProps.put("sasl.jaas.config", jaasConfig);
        configProps.put("security.protocol", protocol);
        configProps.put("enable.idempotence", idempotence);

        DefaultKafkaConsumerFactory<Object, Object> kafkaConsumerFactory =
                new DefaultKafkaConsumerFactory<>(configProps);

        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(kafkaConsumerFactory);
        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,String> listenerContainerFactory2() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress); // servidor
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class); // chave
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class); // valor
        configProps.put(ConsumerConfig.CLIENT_ID_CONFIG, clientId); // client ID
        configProps.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 10); // quantidade de linhas por vez lida
        configProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, EARLIEST);
        configProps.put("sasl.mechanism", saslMechanism);
        configProps.put("sasl.jaas.config", jaasConfig);
        configProps.put("security.protocol", protocol);
        configProps.put("enable.idempotence", idempotence);

        DefaultKafkaConsumerFactory<Object, Object> kafkaConsumerFactory =
                new DefaultKafkaConsumerFactory<>(configProps);

        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(kafkaConsumerFactory);
        return factory;
    }
}
