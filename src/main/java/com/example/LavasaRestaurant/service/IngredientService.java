package com.example.LavasaRestaurant.service;

import com.example.LavasaRestaurant.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class IngredientService {

    private final List<Ingredient> ingredients = new ArrayList<>();
    private final AtomicInteger counter = new AtomicInteger();

    public List<Ingredient> getAllIngredients() {
        return ingredients;
    }

    public Ingredient getIngredientById(int id) {
        return ingredients.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Ingredient addIngredient(Ingredient ingredient) {
        // Set a new ID only if the ingredient is new (id is 0)
        if (ingredient.getId() == 0) {
            ingredient.setId(counter.incrementAndGet());
        }
        ingredients.add(ingredient);
        return ingredient;
    }

    public void deleteIngredient(int id) {
        ingredients.removeIf(i -> i.getId() == id);
    }
}
