package com.arielsoto.elixir.cocktail.common.domain;

import lombok.Data;

@Data
public class Measure {
    private String name;
    private String unit; // Cl, Oz, Ml, Part,

    public Measure(String name, String unit) {
        this.name = name;
        this.unit = unit;
    }

    public String name() { return this.name; }
    public String unit() { return this.unit; }
}
