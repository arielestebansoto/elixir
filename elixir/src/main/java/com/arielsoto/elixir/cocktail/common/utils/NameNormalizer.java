package com.arielsoto.elixir.cocktail.common.utils;

public final class NameNormalizer {
    private NameNormalizer() {}

    public static String normalize(String name) {
        if (name == null) throw new IllegalArgumentException("Name cannot be null");

        return name.toLowerCase().trim().replaceAll("\\s+", "-");
    }
}
