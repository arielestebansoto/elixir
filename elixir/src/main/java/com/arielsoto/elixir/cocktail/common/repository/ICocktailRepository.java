package com.arielsoto.elixir.cocktail.common.repository;

import com.arielsoto.elixir.cocktail.common.domain.Cocktail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICocktailRepository extends MongoRepository<Cocktail, String> {
    Optional<Cocktail> findByNormalizedName(String normalizedName);
}
