package com.arielsoto.elixir.cocktail.common.domain;

import com.arielsoto.elixir.cocktail.common.utils.NameNormalizer;
import lombok.Getter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ingredients")
@Getter
public class Ingredient {
    private String name;
    @Indexed(unique = true)
    private String normalizedName;
    private String type;

    public Ingredient() {}
    
    public Ingredient(String name, String type) {
        this.name = name;
        this.normalizedName = NameNormalizer.normalize(name);
        this.type = type;
    }

    public String name() { return this.name; };
    public String type() { return this.type; };
}
