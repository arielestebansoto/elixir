package com.arielsoto.elixir.cocktail.getbynormalizedname;

import com.arielsoto.elixir.cocktail.common.domain.Recipe;

import java.util.List;

public record RecipeResult(List<IngredientResult> ingredients) {
    public RecipeResult(Recipe recipe) {
        this(recipe.ingredients().ingredients().stream()
            .map(IngredientResult::new)
            .toList());
    }
}
