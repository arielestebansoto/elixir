package com.arielsoto.elixir.cocktail.common.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "grassware")
@Data
public class Glassware {
    public String name;
    public String type;
    public String description;
}
