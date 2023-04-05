package com.vemser.produtor.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {

//    @Value(value = "${kafka.bootstrap-servers}")
//    private String bootstrapAddress; //localhost:9092
//
//    private final String jaasTemplate = "org.apache.kafka.common.security.scram.ScramLoginModule required username=\"%s\" password=\"%s\";";
//
////    -DCLOUDKARAFKA_USERNAME=ca3xrcl7
////-DCLOUDKARAFKA_PASSWORD=cGMbyC0qosoFRegdT63mKvS73mbdKj2q
////-DCLOUDKARAFKA_BROKERS=sulky-01.srvs.cloudkafka.com:9094,sulky-02.srvs.cloudkafka.com:9094,sulky-03.srvs.cloudkafka.com:9094
//
//
//    @Bean
//    public KafkaTemplate<String,String> configKafkaTemplate(){
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress); // servidor
//        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class); // chave
//        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class); // valor
//        configProps.put("sasl.mechanism", "SCRAM-SHA-256");
//        configProps.put("sasl.jaas.config", String.format(jaasTemplate, "ca3xrcl7", "cGMbyC0qosoFRegdT63mKvS73mbdKj2q"));
//        configProps.put("security.protocol", "SASL_SSL");
//        configProps.put("enable.idempotence" , "false");
//
//
//        DefaultKafkaProducerFactory<String, String> kafkaProducerFactory = new DefaultKafkaProducerFactory<>(configProps);
//        return new KafkaTemplate<>(kafkaProducerFactory);
//    }
}