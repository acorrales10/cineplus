/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cine.service;

import com.cine.entity.Salas;
import java.util.List;

/**
 *
 * @author AMCG_
 */
public interface ISalasService {
    
     public List<Salas> getAllSalas();
    public Salas getSalasById (long id);
    public void saveSalas(Salas salas);
    public void delete (long id);
    
}
