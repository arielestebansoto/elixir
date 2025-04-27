package com.arielsoto.elixir.cocktail.common.domain;

import lombok.Data;

@Data
public class Measure {
    private String name;
    private String unit; // Cl, Oz, Ml, Part,

    private Measure(String name, String unit) {
        this.name = name;
        this.unit = unit;
    }

    public String name() { return this.name; }
    public String unit() { return this.unit; }

    public static Measure ounce() {
        return new Measure("Ounce", "Oz");
    }

    public static Measure centiliter() {
        return new Measure("Centiliter", "Cl");
    }

    public static Measure milliliter() {
        return new Measure("Milliliter", "Ml");
    }

    public static Measure part() {
        return new Measure("Part", "Part");
    }
}
