package com.arielsoto.elixir;

import com.arielsoto.elixir.cocktail.common.domain.*;
import com.arielsoto.elixir.cocktail.common.repository.ICocktailRepository;
import com.arielsoto.elixir.cocktail.common.repository.IMeasureRepository;
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

import java.util.Optional;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.oauth2Login;
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
	private IMeasureRepository measureRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	void contextLoads(@Autowired final MongoTemplate mongoTemplate) {
		Assertions.assertThat(mongoTemplate.getDb()).isNotNull();
	}

	@BeforeEach
	void setUp() {
		cleanDB();

		Measure ounce = new Measure("ounce", "oz");
		measureRepository.save(ounce);
		Optional<Measure> oz = measureRepository.findByNormalizedName("ounce");

		if (oz.isEmpty())
			throw new IllegalArgumentException("Measure " + ounce.name() + " not found.");

		Recipes recipesMojito = getRecipes(oz);
		Cocktail mojito = new Cocktail("Mojito", recipesMojito);
		repository.save(mojito);
	}

	private void cleanDB() {
		repository.deleteAll();
		measureRepository.deleteAll();
	}

	private static Recipes getRecipes(Optional<Measure> oz) {
		Amount rumAmount = new Amount(oz.get(), 2);

		Ingredient rum = new Ingredient("Rum", "distilled alcoholic ");
		RecipeIngredient mojitoRum = new RecipeIngredient(rum, rumAmount);

		Amount juiceLimeAmount = new Amount(oz.get(), 1);
		Ingredient lime = new Ingredient("Lime", "fruit juice ");
		RecipeIngredient mojitoLime = new RecipeIngredient(lime, juiceLimeAmount);

		Recipe mojitoRecipe = new Recipe();
		mojitoRecipe.addIngredient(mojitoRum);
		mojitoRecipe.addIngredient(mojitoLime);

		Recipes recipesMojito = new Recipes();
		recipesMojito.addRecipe(mojitoRecipe);
		return recipesMojito;
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
	void shouldReturnUnauthorizedWhenCreatingCocktailWithoutAuth() throws Exception {
		mockMvc.perform(post("/api/v1/cocktails/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content("""
					{
						"name": "Mojito"
					}
				"""))
				.andExpect(status().isFound())
				.andExpect(header().string("Location", "http://localhost/login"));
	}

	@Test
	void shouldCreateCocktailWhenAuthenticated() throws Exception {
		mockMvc.perform(post("/api/v1/cocktails/create")
				.with(oauth2Login())
				.contentType(MediaType.APPLICATION_JSON)
				.content("""
					{
						"name": "Vodka Martini"
					}
				"""))
				.andExpect(status().isOk());
	}
}