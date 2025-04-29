package com.arielsoto.elixir.cocktail.common.domain;

import com.arielsoto.elixir.cocktail.common.utils.NameNormalizer;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@Getter
public abstract class NamedDocument {
    @Id
    protected String id;

    protected String name;

    @Indexed(unique = true)
    protected String normalizedName;

    public NamedDocument() {}

    public NamedDocument(String name) {
        if (name == null) throw new IllegalArgumentException("Name cannot be null or blank.");

        this.name = name;
        this.normalizedName = NameNormalizer.normalize(name);
    }

    public String name() { return name; }
    public String normalizedName() { return normalizedName; }
}
