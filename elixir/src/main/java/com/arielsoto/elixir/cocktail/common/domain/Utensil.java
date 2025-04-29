package com.arielsoto.elixir.cocktail.common.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "methods")
@Data
public class Utensil {
    public String description;
}
