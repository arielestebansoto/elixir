package com.arielsoto.elixir.cocktail.common.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Ingredients {
    private List<RecipeIngredient> ingredients;

    public Ingredients() {
        this.ingredients = new ArrayList<RecipeIngredient>();
    }

    public void addIngredient(RecipeIngredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public List<RecipeIngredient> ingredients() {
        return this.ingredients;
    }
}
