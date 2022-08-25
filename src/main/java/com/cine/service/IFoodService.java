/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cine.service;

import com.cine.entity.Food;
import java.util.List;

/**
 *
 * @author AMCG_
 */
public interface IFoodService {
     public List<Food> getAllFood();
    public Food getFoodById (long id);
    public void saveFood(Food food);
    public void delete (long id);
    
}
