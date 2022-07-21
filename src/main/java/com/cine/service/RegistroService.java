/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.service;

import com.cine.entity.Registro;
import com.cine.repository.RegistroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AMCG_
 */
 @Service
public class RegistroService implements IRegistroService {
  
    @Autowired
    private RegistroRepository registroRepository;
    
    @Override
    public List<Registro> getAllRegistro() {
        return (List<Registro>) registroRepository.findAll();
        
    }

    @Override
    public Registro getRegistroById(long id) {
        return registroRepository.findById(id).orElse(null);
    }

    @Override
    public void saveRegistro(Registro registro) {
       registroRepository.save(registro);
    }

    @Override
    public void delete(long id) {
        registroRepository.deleteById(id);
        
    }  
}
