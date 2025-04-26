package com.arielsoto.elixir.cocktail.common.domain;

import lombok.Data;

import java.util.List;

@Data
public class Garnish {
    public String name;
    public List<Ingredient> ingredients;
    public String family;
}
