package com.example.LavasaRestaurant.controller;

import com.example.LavasaRestaurant.model.Menu;
import com.example.LavasaRestaurant.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller for handling Menu-related API requests
@RestController
@RequestMapping("/api/menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("/{id}")
    public Menu getMenuById(@PathVariable int id) {
        return menuService.getMenuById(id);
    }

    @PostMapping
    public Menu addMenu(@RequestBody Menu menu) {
        return menuService.addMenu(menu);
    }

    @DeleteMapping("/{id}")
    public void deleteMenu(@PathVariable int id) {
        menuService.deleteMenu(id);
    }
}
