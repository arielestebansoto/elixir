package com.arielsoto.elixir.cocktail.getbynormalizedname;

import com.arielsoto.elixir.cocktail.common.domain.Recipe;
import com.arielsoto.elixir.cocktail.common.domain.Recipes;

import java.util.List;

public record RecipesResult(List<RecipeResult> recipes) {
    public RecipesResult(Recipes recipes) {
        this(recipes.recipes().stream()
            .map(RecipeResult::new)
            .toList());
    }
}
