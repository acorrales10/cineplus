/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.service;

import com.cine.entity.Salas;
import com.cine.repository.SalasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AMCG_
 */
@Service
public class SalasService implements ISalasService {

    @Autowired
    private SalasRepository salasRepository;

    @Override
    public List<Salas> getAllSalas() {
        return (List<Salas>) salasRepository.findAll();
    }

    @Override
    public Salas getSalasById(long id) {
        return salasRepository.findById(id).orElse(null);
    }

    @Override
    public void saveSalas(Salas salas) {
        salasRepository.save(salas);
    }

    @Override
    public void delete(long id) {
        salasRepository.deleteById(id);
    }

}
