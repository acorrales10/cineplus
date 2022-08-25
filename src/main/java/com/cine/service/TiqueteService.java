/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.service;

import com.cine.commons.JasperReportManager;
import com.cine.dto.ReporteTiqueteDTO;
import com.cine.entity.Registro;
import com.cine.entity.Tiquete;
import com.cine.repository.TiqueteRepository;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AMCG_
 */
@Service
public class TiqueteService implements ITiqueteService{
    
    @Autowired
    private JasperReportManager reportManager;
    
    @Autowired
    private TiqueteRepository tiqueteRepository;
    
     @Autowired
    private DataSource dataSource;

    @Override
    public List<Tiquete> getAllTiquetes() {
        return (List<Tiquete>) tiqueteRepository.findAll();
    }

    @Override
    public Tiquete getTiqueteById(long id) {
       return tiqueteRepository.findById(id).orElse(null);
    }

    @Override
    public void saveTiquete(Tiquete tiquete) {
        tiqueteRepository.save(tiquete);
    }

    @Override
    public void delete(long id) {
        tiqueteRepository.deleteById(id);
    }

    @Override
    public List<Tiquete> findAllByUsuarioId(int id) {
        return tiqueteRepository.findAllByRegistro(id);
    }

    @Override
    public Tiquete getTiqueteByCodigo(String codigo) {
        return tiqueteRepository.findByCodigo(codigo);
    }
    
    
     @Override
    public ReporteTiqueteDTO obtenerReporte(Map<String, Object> params) throws JRException, IOException, SQLException {
        String fileName = "tiquete";
        ReporteTiqueteDTO dto = new ReporteTiqueteDTO();
        String extension = ".pdf";
        dto.setFileName(fileName + extension);

        ByteArrayOutputStream stream = reportManager.export(fileName,extension, params,
                dataSource.getConnection());

        byte[] bs = stream.toByteArray();
        dto.setStream(new ByteArrayInputStream(bs));
        dto.setLength(bs.length);

        return dto;
    }
}
