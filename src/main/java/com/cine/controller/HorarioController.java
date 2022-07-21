/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.controller;

import com.cine.entity.Horario;
import com.cine.service.IHorarioService;
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
public class HorarioController {
    
    @Autowired
    private IHorarioService horarioService;
    
     @GetMapping("/horario")
    public String index(Model model) {
        List<Horario> listaHorario = horarioService.getAllHorario();
        model.addAttribute("titulo", "Tabla horario");
        model.addAttribute("horario", listaHorario);
        return "horario";
    
    
}
    
      @GetMapping("/horario/crear")
    public String crearHorario(Model model) {
        model.addAttribute("horario", new Horario());
        return "crear_horario";

    }
    
    @PostMapping("/horario/save")
    public String guardarHorario(@ModelAttribute Horario horario) {
        horarioService.saveHorario(horario);
        return "redirect:/horario";
    }
    
     @GetMapping("/horario/editHorario/{id}")
    public String editarHorario(@PathVariable("id") Long idHorario, Model model) {
        Horario horario = horarioService.getHorarioById(idHorario);
        model.addAttribute("horario", horario);
        return "crear_horario";

    }
    
    @GetMapping("/horario/delete/{id}")
    public String eliminarHorario(@PathVariable("id") Long idHorario, Model model) {
        horarioService.delete(idHorario);
        return "redirect:/horario";

    }
}
