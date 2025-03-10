package com.arielsoto.elixir;

import com.arielsoto.elixir.config.EmbeddedMongoConfiguration;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataMongoTest
@ExtendWith(SpringExtension.class)
@Import(EmbeddedMongoConfiguration.class)
class ElixirApplicationTests {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	void contextLoads(@Autowired final MongoTemplate mongoTemplate) {
		Assertions.assertThat(mongoTemplate.getDb()).isNotNull();
	}
}
