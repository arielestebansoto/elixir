package com.arielsoto.elixir.cocktail.createcokctail;

import lombok.AllArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/cocktails/create")
@AllArgsConstructor
public class CreateCocktailController {
    private final CreateCocktailHandler handler;

    @PostMapping
    public ResponseEntity<?> createCocktail(@RequestBody CreateCocktailCommand command) {
        try {
            CocktailResult createdCocktail = handler.handle(command);
            return ResponseEntity.ok(createdCocktail);
        } catch (DuplicateKeyException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
