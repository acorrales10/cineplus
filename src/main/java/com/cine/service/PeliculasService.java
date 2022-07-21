/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.service;

import com.cine.entity.Peliculas;
import com.cine.repository.PeliculasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AMCG_
 */
@Service
public class PeliculasService implements IPeliculasService {
    
    @Autowired
    private PeliculasRepository peliculasRepository;

    @Override
    public List<Peliculas> getAllPeliculas() {
        return (List<Peliculas>) peliculasRepository.findAll();
    }

    @Override
    public Peliculas getPeliculasById(long id) {
        return peliculasRepository.findById(id).orElse(null);
    }

    @Override
    public void savePeliculas(Peliculas peliculas) {
        peliculasRepository.save(peliculas);
    }

    @Override
    public void delete(long id) {
        peliculasRepository.deleteById(id);
    }
    
}
