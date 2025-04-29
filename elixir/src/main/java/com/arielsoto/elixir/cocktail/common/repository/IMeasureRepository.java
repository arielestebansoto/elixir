package com.arielsoto.elixir.cocktail.common.repository;

import com.arielsoto.elixir.cocktail.common.domain.Measure;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IMeasureRepository extends MongoRepository<Measure, String> {
    Optional<Measure> findByNormalizedName(String normalizedName);
}
