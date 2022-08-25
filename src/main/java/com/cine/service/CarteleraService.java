/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.service;

import com.cine.entity.Cartelera;
import com.cine.repository.CarteleraRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AMCG_
 */
@Service
public class CarteleraService implements ICarteleraService{
    
    @Autowired
    private CarteleraRepository carteleraRepository;

    @Override
    public List<Cartelera> getAllCartelera() {
        return (List<Cartelera>) carteleraRepository.findAll();
    }

    @Override
    public Cartelera getCarteleraById(long id) {
       return carteleraRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCartelera(Cartelera cartelera) {
        carteleraRepository.save(cartelera);
    }

    @Override
    public void delete(long id) {
        carteleraRepository.deleteById(id);
    }

    @Override
    public List<Cartelera> getAllCarteleraActivas() {
        return (List<Cartelera>) carteleraRepository.findAllByActivo(true);
    }
    
    @Override
    public List<Cartelera> getAllCarteleraCarousel() {
        return (List<Cartelera>) carteleraRepository.findAllByHome(true);
    }
    
    @Override
    public List<Cartelera> getAllCarteleraPreventa() {
        return (List<Cartelera>) carteleraRepository.findAllByPreventa(true);
    }
    
}
