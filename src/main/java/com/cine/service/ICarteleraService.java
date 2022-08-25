/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cine.service;

import com.cine.entity.Cartelera;
import java.util.List;

/**
 *
 * @author AMCG_
 */
public interface ICarteleraService {
    
    public List<Cartelera> getAllCartelera();
    public Cartelera getCarteleraById (long id);
    public void saveCartelera(Cartelera cartelera);
    public void delete (long id);
    public List<Cartelera> getAllCarteleraActivas();
    public List<Cartelera> getAllCarteleraCarousel();
    public List<Cartelera> getAllCarteleraPreventa();
    
    
}
