package com.arielsoto.elixir.cocktail.common.domain;

import lombok.Data;

@Data
public class Amount {
    private Measure measure;
    public double quantity;

    public Amount(Measure measure, double quantity) {
        this.measure = measure;
        this.quantity = quantity;
    }

    public String unit() { return this.measure.unit(); }
}
