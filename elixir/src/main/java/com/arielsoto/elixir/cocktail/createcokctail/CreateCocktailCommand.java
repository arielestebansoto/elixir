package com.arielsoto.elixir.cocktail.createcokctail;

import com.arielsoto.elixir.cocktail.common.domain.Recipes;

public record CreateCocktailCommand(String name, Recipes recipes) { }
