/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.dto;

import com.cine.entity.Carrito;
import com.cine.entity.Tiquete;
import java.util.List;

/**
 *
 * @author AMCG_
 */
public class CrearTiqueteDto {
    
    private List<Carrito> productos;
    private Tiquete tiquete;
    private String tarjeta;
    
    private void addProducto(Carrito carrito){
        this.productos.add(carrito);
    }

    public List<Carrito> getProductos() {
        return productos;
    }

    public void setProductos(List<Carrito> productos) {
        this.productos = productos;
    }

    public Tiquete getTiquete() {
        return tiquete;
    }

    public void setTiquete(Tiquete tiquete) {
        this.tiquete = tiquete;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }
    
    
    
    
}
