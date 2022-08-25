/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.controller;

import com.cine.entity.Food;
import com.cine.service.IFoodService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author AMCG_
 */
@Controller
public class FoodController {

    @Autowired
    private IFoodService foodService;

    @GetMapping("/admin/food")
    public String index(Model model) {
        List<Food> listaFood = foodService.getAllFood();
        model.addAttribute("titulo", "Tabla Productos");
        model.addAttribute("foods", listaFood);
        return "administrador/food";

    }

    @GetMapping("admin/food/crear")
    public String crearFood(Model model) {
        model.addAttribute("food", new Food());
        return "administrador/crear_food";

    }

    @PostMapping("admin/food/save")
    public String guardarFood(@ModelAttribute Food food) {
        foodService.saveFood(food);
        return "redirect:/admin/food";
    }

    @GetMapping("admin/food/editFood/{id}")
    public String editarFood(@PathVariable("id") Long idFood, Model model) {
        Food food = foodService.getFoodById(idFood);
        model.addAttribute("food", food);
        return "administrador/crear_food";

    }

    @GetMapping("/food/delete/{id}")
    public String eliminarFood(@PathVariable("id") Long idFood, Model model) {
        foodService.delete(idFood);
        return "redirect:/food";

    }
}


