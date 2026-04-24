package com.example.LavasaRestaurant.service;

import com.example.LavasaRestaurant.model.Menu;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class MenuService {

    private final List<Menu> menus = new ArrayList<>();
    private final AtomicInteger counter = new AtomicInteger();
    private final IngredientService ingredientService;

    public MenuService(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    public List<Menu> getAllMenus() {
        return menus;
    }

    public Menu getMenuById(int id) {
        return menus.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Menu addMenu(Menu menu) {
        if (menu.getId() == 0) {
            menu.setId(counter.incrementAndGet());
        }
        menus.add(menu);
        return menu;
    }

    public void deleteMenu(int id) {
        menus.removeIf(m -> m.getId() == id);
    }
}
