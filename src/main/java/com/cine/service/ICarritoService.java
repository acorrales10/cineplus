/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cine.service;

import com.cine.entity.Carrito;
import java.util.List;

/**
 *
 * @author AMCG_
 */
public interface ICarritoService {
    public List<Carrito> getAllCarritos();
    public List<Carrito> findAllByTiqueteId(long id);
    public Carrito getCarritoById (long id);
    public void saveCarrito(Carrito tiquete);
    public void delete (long id);   
}
