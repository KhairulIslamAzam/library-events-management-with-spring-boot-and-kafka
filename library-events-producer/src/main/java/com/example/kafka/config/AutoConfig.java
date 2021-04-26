package com.example.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author Khairul Islam Azam
 * @created 25/04/2021 - 10:33 PM
 * @project IntelliJ IDEA
 */
@Configuration
@Profile("local") //this means this config is only for local not for dev or prod
public class AutoConfig {

    @Bean
    public NewTopic libraryEvents(){
        return TopicBuilder.name("library-events")
                .partitions(3)
                .replicas(3)
                .build();
    }
}
