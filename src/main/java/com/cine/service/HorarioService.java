/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.service;

import com.cine.entity.Horario;
import com.cine.repository.HorarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AMCG_
 */
@Service
public class HorarioService implements IHorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    @Override
    public List<Horario> getAllHorario() {
        return (List<Horario>) horarioRepository.findAll();
    }

    @Override
    public Horario getHorarioById(long id) {
        return horarioRepository.findById(id).orElse(null);
    }

    @Override
    public void saveHorario(Horario horario) {
        horarioRepository.save(horario);
    }

    @Override
    public void delete(long id) {
        horarioRepository.deleteById(id);
    }

}
