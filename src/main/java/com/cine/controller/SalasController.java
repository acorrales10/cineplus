/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.controller;

import com.cine.entity.Salas;
import com.cine.service.ISalasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author AMCG_
 */
@Controller
public class SalasController {
    
    @Autowired
    private ISalasService salasService;
    
     @GetMapping("/salas")
    public String index(Model model) {
        List<Salas> listaSalas = salasService.getAllSalas();
        model.addAttribute("titulo", "Tabla salas");
        model.addAttribute("salas", listaSalas);
        return "salas";
    
}
    
    @GetMapping("/salas/crear")
    public String crearSalas(Model model) {
        model.addAttribute("salas", new Salas());
        return "crear_sala";

    }
    
     @PostMapping("/salas/save")
    public String guardarSalas(@ModelAttribute Salas salas) {
        salasService.saveSalas(salas);
        return "redirect:/salas";
    }
    
   @GetMapping("/salas/editSalas/{id}")
    public String editarSalas(@PathVariable("id") Long idSalas, Model model) {
        Salas salas = salasService.getSalasById(idSalas);
        model.addAttribute("Salas", salas);
        return "crear_sala";

    }
    
    @GetMapping("/salas/delete/{id}")
    public String eliminarSalas(@PathVariable("id") Long idSalas, Model model) {
        salasService.delete(idSalas);
        return "redirect:/salas";

    }
    
}
