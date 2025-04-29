package com.arielsoto.elixir.cocktail.common.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ice")
@Data
public class Ice {
    public String name;
}
