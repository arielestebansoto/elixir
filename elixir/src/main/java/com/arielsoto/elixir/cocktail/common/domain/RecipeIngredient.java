package com.arielsoto.elixir.cocktail.common.domain;

import lombok.Data;

@Data
public class RecipeIngredient {
    private Ingredient ingredient;
    private Amount amount;

    public RecipeIngredient(Ingredient ingredient, Amount amount) {
        this.ingredient = ingredient;
        this.amount = amount;
    }

    public String name() { return this.ingredient.name(); };
    public double quantity() { return this.amount.quantity; }
    public String unit() { return this.amount.unit(); }
}
