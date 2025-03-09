package com.arielsoto.elixir.cocktail.common.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Cocktail {
    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String normalizedName;

    public Cocktail(String name) {
        this.name = name;
        this.normalizedName = this.normalizeName(name);
    }

    private String normalizeName(String name) {
        return name.toLowerCase().trim().replaceAll("\\s+", "-");
    }

    public String id() { return this.id; }
    public String name() { return this.name; }
    public String normalizedName() { return this.normalizedName; }
}
