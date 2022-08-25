/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.service;

import com.cine.entity.Food;
import com.cine.entity.Horario;
import com.cine.repository.FoodRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AMCG_
 */
@Service
public class FoodService implements IFoodService {
    
    @Autowired
    private FoodRepository foodRepository;

    @Override
    public List<Food> getAllFood() {
         return (List<Food>) foodRepository.findAll();
        
    }

    
    @Override
    public Food getFoodById(long id) {
        return foodRepository.findById(id).orElse(null);
       
    }

    @Override
    public void saveFood(Food food) {
        foodRepository.save(food);
    }

    @Override
    public void delete(long id) {
        foodRepository.deleteById(id);
        
    }
    
}
