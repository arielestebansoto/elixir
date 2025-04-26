package com.arielsoto.elixir.cocktail.getbynormalizedname;

import com.arielsoto.elixir.cocktail.common.domain.Cocktail;

public record CocktailResult(String name, String normalizedName, RecipesResult recipes) {
    public CocktailResult(Cocktail cocktail) {
        this(
                cocktail.name(),
                cocktail.normalizedName(),
                new RecipesResult(cocktail.recipes())
        );
    }
}
