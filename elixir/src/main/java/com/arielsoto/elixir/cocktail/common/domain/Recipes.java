package com.arielsoto.elixir.cocktail.common.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Recipes {
    private List<Recipe> recipes;

    public Recipes() {
        this.recipes = new ArrayList<Recipe>();
    }

    public List<Recipe> recipes() { return recipes; }

    public void addRecipe(Recipe recipe) {
        this.recipes.add(recipe);
    }
}
