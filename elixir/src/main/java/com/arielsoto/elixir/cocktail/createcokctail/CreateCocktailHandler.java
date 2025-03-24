package com.arielsoto.elixir.cocktail.createcokctail;

import com.arielsoto.elixir.cocktail.common.domain.Cocktail;
import com.arielsoto.elixir.cocktail.common.repository.ICocktailRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateCocktailHandler {
    private final ICocktailRepository repository;

    public CocktailResult handle(CreateCocktailCommand command) {
        Cocktail newCocktail = new Cocktail(command.name());

        if (repository.findByNormalizedName(newCocktail.normalizedName()).isPresent())
            throw new DuplicateKeyException("Cocktail " + newCocktail.normalizedName() + " already exists.");

        repository.insert(newCocktail);

        return new CocktailResult(newCocktail.name(), newCocktail.normalizedName());
    }
}
