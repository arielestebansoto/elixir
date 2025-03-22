package com.arielsoto.elixir.cocktail.getbynormalizedname;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/cocktails/get/{normalizedName}")
@AllArgsConstructor
public class GetCocktailByNormalizedNameController {
    private final GetCocktailByNormalizedNameHandler handler;

    @GetMapping
    public ResponseEntity<CocktailResult> getCocktailByNormalizeName(@PathVariable String normalizedName) {
        GetCocktailByNormalizedNameQuery query = new GetCocktailByNormalizedNameQuery(normalizedName);

        Optional<CocktailResult> cocktail = handler.handle(query);

        return cocktail.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
