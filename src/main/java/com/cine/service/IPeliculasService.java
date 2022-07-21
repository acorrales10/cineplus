/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cine.service;

import com.cine.entity.Peliculas;
import java.util.List;

/**
 *
 * @author AMCG_
 */
public interface IPeliculasService {
    
    
    public List<Peliculas> getAllPeliculas();
    public Peliculas getPeliculasById (long id);
    public void savePeliculas(Peliculas peliculas);
    public void delete (long id);
    
    
}
