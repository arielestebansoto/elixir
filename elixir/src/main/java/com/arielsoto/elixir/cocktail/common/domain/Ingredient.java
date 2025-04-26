package com.arielsoto.elixir.cocktail.common.domain;

import lombok.Data;

@Data
public class Ingredient {
    private String name;
    private String type;

    public Ingredient(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String name() { return this.name; };
    public String type() { return this.type; };
}
