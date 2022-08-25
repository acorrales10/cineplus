/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.service;

import com.cine.entity.Carrito;
import com.cine.repository.CarritoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AMCG_
 */
@Service
public class CarritoService implements ICarritoService{
    
    @Autowired
    private CarritoRepository carritoRepository;

    @Override
    public List<Carrito> getAllCarritos() {
        return (List<Carrito>) carritoRepository.findAll();
    }

    @Override
    public Carrito getCarritoById(long id) {
       return carritoRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCarrito(Carrito carrito) {
        carritoRepository.save(carrito);
    }

    @Override
    public void delete(long id) {
        carritoRepository.deleteById(id);
    }

    @Override
    public List<Carrito> findAllByTiqueteId(long id) {
        return carritoRepository.findAllByTiqueteId(id);
    }
    
}
