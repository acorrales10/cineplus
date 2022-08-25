/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.dto;

import com.cine.entity.Carrito;
import java.util.List;

/**
 *
 * @author AMCG_
 */
public class CrearCarritoDto {
    private List<Carrito> productos;
    
    private void addProducto(Carrito carrito){
        this.productos.add(carrito);
    }

    public List<Carrito> getProductos() {
        return productos;
    }

    public void setProductos(List<Carrito> productos) {
        this.productos = productos;
    }
    
    
    
}
