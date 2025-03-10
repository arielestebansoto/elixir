package com.arielsoto.elixir.config;

import org.springframework.context.annotation.Bean;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
public class EmbeddedMongoConfiguration {
    String mongoUri = System.getenv("TEST_MONGO_URI");

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(new SimpleMongoClientDatabaseFactory(mongoUri));
    }
}
