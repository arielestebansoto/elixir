package com.arielsoto.elixir.cocktail.common.domain;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ingredients")
@Getter
public class Ingredient extends NamedDocument {
    private String type;

    public Ingredient() {}
    
    public Ingredient(String name, String type) {
        super(name);
        this.type = type;
    }

    public String type() { return this.type; }
}
