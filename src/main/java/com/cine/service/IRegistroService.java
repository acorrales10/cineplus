/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cine.service;

import com.cine.entity.Registro;
import java.util.List;

/**
 *
 * @author AMCG_
 */
public interface IRegistroService {
    
    public List<Registro> getAllRegistro();
    public Registro getRegistroById (long id);
    public void saveRegistro(Registro registro);
    public void delete (long id);
    
}
