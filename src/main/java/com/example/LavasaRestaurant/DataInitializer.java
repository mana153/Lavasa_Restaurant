package com.example.LavasaRestaurant;

import com.example.LavasaRestaurant.model.Ingredient;
import com.example.LavasaRestaurant.model.Menu;
import com.example.LavasaRestaurant.service.IngredientService;
import com.example.LavasaRestaurant.service.MenuService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final IngredientService ingredientService;
    private final MenuService menuService;

    public DataInitializer(IngredientService ingredientService, MenuService menuService) {
        this.ingredientService = ingredientService;
        this.menuService = menuService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Add Ingredients
        Ingredient tomatoes = ingredientService.addIngredient(new Ingredient(0, "Tomatoes", 10));
        Ingredient cheese = ingredientService.addIngredient(new Ingredient(0, "Cheese", 20));
        Ingredient dough = ingredientService.addIngredient(new Ingredient(0, "Dough", 5));

        // Create a list of ingredients for the menu
        List<Ingredient> pizzaIngredients = new ArrayList<>();
        pizzaIngredients.add(tomatoes);
        pizzaIngredients.add(cheese);
        pizzaIngredients.add(dough);

        // Add Menu
        menuService.addMenu(new Menu(0, "Margherita Pizza", "Classic pizza with tomatoes and cheese", 12.99, pizzaIngredients));
    }
}
