package com.arielsoto.elixir.cocktail.common.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "garnishes")
@Data
public class Garnish {
    public String name;
    public List<Ingredient> ingredients;
    public String family;
}
