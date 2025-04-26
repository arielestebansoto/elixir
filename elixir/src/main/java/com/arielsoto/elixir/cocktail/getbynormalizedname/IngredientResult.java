package com.arielsoto.elixir.cocktail.getbynormalizedname;

import com.arielsoto.elixir.cocktail.common.domain.RecipeIngredient;

public record IngredientResult(String name, double quantity, String unit) {
    public IngredientResult(RecipeIngredient ingredient) {
        this(
                ingredient.name(),
                ingredient.quantity(),
                ingredient.unit()
        );
    }
}
