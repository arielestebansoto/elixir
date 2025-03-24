package com.arielsoto.elixir;

import com.arielsoto.elixir.cocktail.common.domain.Cocktail;
import com.arielsoto.elixir.cocktail.common.repository.ICocktailRepository;
import com.arielsoto.elixir.config.EmbeddedMongoConfiguration;
import com.arielsoto.elixir.config.TestSecurityConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.BasicJsonTester;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Import({EmbeddedMongoConfiguration.class, TestSecurityConfig.class})
@AutoConfigureMockMvc
class ElixirApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ICocktailRepository repository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	void contextLoads(@Autowired final MongoTemplate mongoTemplate) {
		Assertions.assertThat(mongoTemplate.getDb()).isNotNull();
	}

	@BeforeEach
	void setUp() {
		repository.deleteAll();
		Cocktail cocktail = new Cocktail("Mojito");
		repository.save(cocktail);
	}

	@Test
	void shouldReturnOkWhenGetCocktail() throws Exception {
		mockMvc.perform(get("/api/v1/cocktails/get/mojito"))
				.andExpect(status().isOk());
	}

	@Test
	void shouldReturnExactCocktailData() throws Exception {
		String response = mockMvc.perform(get("/api/v1/cocktails/get/mojito"))
				.andDo(MockMvcResultHandlers.print())
				.andReturn()
				.getResponse()
				.getContentAsString();

		BasicJsonTester jsonTester = new BasicJsonTester(getClass());

		Assertions.assertThat(jsonTester.from(response))
				.isStrictlyEqualToJson("""
						{
							"name": "Mojito",
							"normalizedName": "mojito"
						}
				""");
	}

	@Test
	void shoudlReturnAnauthorizedWhenCreatingCocktailWithoutAuth() throws Exception {
		mockMvc.perform(post("/api/v1/cocktails/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content("""
					{
						"name": "Mojito"
					}
				"""))
				.andExpect(status().isForbidden());
	}
}