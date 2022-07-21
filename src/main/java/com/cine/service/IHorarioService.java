/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cine.service;

import com.cine.entity.Horario;
import java.util.List;

/**
 *
 * @author AMCG_
 */
public interface IHorarioService {
    public List<Horario> getAllHorario();
    public Horario getHorarioById (long id);
    public void saveHorario(Horario horario);
    public void delete (long id);
    
}
