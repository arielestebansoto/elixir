package com.arielsoto.elixir.cocktail.common.domain;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "measures")
@Getter
public class Measure extends NamedDocument {
    private String unit;

    public Measure() {}

    public Measure(String name, String unit) {
        super(name);
        this.unit = unit;
    }

    public String unit() { return this.unit; }
}
