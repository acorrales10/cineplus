/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cine.service;

import com.cine.dto.ReporteTiqueteDTO;
import com.cine.entity.Registro;
import com.cine.entity.Tiquete;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author AMCG_
 */
public interface ITiqueteService {
    public List<Tiquete> getAllTiquetes();
    public List<Tiquete> findAllByUsuarioId(int id);
    public Tiquete getTiqueteById (long id);
    public Tiquete getTiqueteByCodigo (String codigo);
    public void saveTiquete(Tiquete tiquete);
    public void delete (long id);   
    public ReporteTiqueteDTO obtenerReporte(Map<String, Object> params) throws JRException, IOException, SQLException;
}
