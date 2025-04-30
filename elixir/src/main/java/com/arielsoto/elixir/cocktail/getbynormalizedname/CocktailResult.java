package com.arielsoto.elixir.cocktail.getbynormalizedname;

import com.arielsoto.elixir.cocktail.common.domain.Cocktail;

import java.util.List;

public record CocktailResult(String name, String normalizedName, List<RecipeResult> recipes) {
    public CocktailResult(Cocktail cocktail) {
        this(
                cocktail.name(),
                cocktail.normalizedName(),
                cocktail.recipes().recipes().stream()
                        .map(RecipeResult::new)
                        .toList()
        );
    }
}
