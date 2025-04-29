package com.arielsoto.elixir.cocktail.common.repository;

import com.arielsoto.elixir.cocktail.common.domain.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IIngredientRepository extends MongoRepository<Ingredient, String> {
    Optional<Ingredient> findByNormalizedName(String normalizedName);
}
