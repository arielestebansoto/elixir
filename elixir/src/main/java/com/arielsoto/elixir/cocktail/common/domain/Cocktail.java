package com.arielsoto.elixir.cocktail.common.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Data
@Document
public class Cocktail {
    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String normalizedName;
    private Recipes recipes;

    public Cocktail(String name, Recipes recipes) {
        Objects.requireNonNull(recipes);

        if (recipes.recipes() == null || recipes.recipes().isEmpty())
            throw new IllegalArgumentException("A Cocktail must have at least one recipe.");

        this.name = name;
        this.normalizedName = this.normalizeName(name);
        this.recipes = recipes;
    }

    private String normalizeName(String name) {
        return name.toLowerCase().trim().replaceAll("\\s+", "-");
    }

    public String id() { return this.id; }
    public String name() { return this.name; }
    public String normalizedName() { return this.normalizedName; }
    public Recipes recipes() { return this.recipes; }
}
