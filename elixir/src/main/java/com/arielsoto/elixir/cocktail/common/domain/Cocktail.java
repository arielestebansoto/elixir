package com.arielsoto.elixir.cocktail.common.domain;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "cocktails")
@Getter
public class Cocktail extends NamedDocument {
    private Recipes recipes;

    public Cocktail(String name, Recipes recipes) {
        super(name);
        this.recipes = Objects.requireNonNull(recipes);
    }

    public Recipes recipes() { return this.recipes; }
}
