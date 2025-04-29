package com.arielsoto.elixir.cocktail.common.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "measures")
@Getter
public class Measure {
    @Id
    private String Id;

    private String name;
    @Indexed(unique = true)
    private String normalizedName;
    private String unit;

    public Measure() {}

    public Measure(String name, String unit) {
        this.name = name;
        this.normalizedName = this.normalizeName(name);
        this.unit = unit;
    }

    public String name() { return this.name; }
    public String unit() { return this.unit; }

    private String normalizeName(String name) {
        return name.toLowerCase().trim().replaceAll("\\s+", "-");
    }
}
