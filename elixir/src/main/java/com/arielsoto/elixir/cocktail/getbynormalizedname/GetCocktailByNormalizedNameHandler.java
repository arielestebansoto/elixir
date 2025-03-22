package com.arielsoto.elixir.cocktail.getbynormalizedname;

import com.arielsoto.elixir.cocktail.common.repository.ICocktailRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetCocktailByNormalizedNameHandler {
    private final ICocktailRepository repository;

    public Optional<CocktailResult> handle(GetCocktailByNormalizedNameQuery query) {
        return repository.findByNormalizedName(query.normalizedName())
                .map(CocktailResult::new);
    }
}
