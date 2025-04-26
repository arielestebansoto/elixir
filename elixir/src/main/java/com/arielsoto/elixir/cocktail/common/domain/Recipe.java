package com.arielsoto.elixir.cocktail.common.domain;

import lombok.Data;

import java.util.List;

@Data
public class Recipe {
    public Method method;
    private Ingredients ingredients;
    public Ice ice;
    public Glassware glassware;
    public Garnish garnish;
    public List<Utensil> utensils;
    public Preparation preparation;
    public Author author;

    public Recipe() {
        this.ingredients = new Ingredients();
    }

    public void addIngredient(RecipeIngredient ingredient) {
        this.ingredients.addIngredient(ingredient);
    }

    public Ingredients ingredients() {
        return this.ingredients;
    }
}
