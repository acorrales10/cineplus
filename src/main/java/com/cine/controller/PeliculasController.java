/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.controller;

import com.cine.entity.Peliculas;
import com.cine.service.IPeliculasService;
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
public class PeliculasController {
    
    @Autowired
    private IPeliculasService peliculasService;
    
    @GetMapping("/admin/peliculas")
    public String index(Model model) {
        List<Peliculas> listaPeliculas = peliculasService.getAllPeliculas();
        model.addAttribute("titulo", "Tabla Peliculas");
        model.addAttribute("peliculas", listaPeliculas);
        return "administrador/peliculas";   
}
  @GetMapping("/admin/peliculas/crear")
    public String crearPeliculas(Model model) {
        model.addAttribute("pelicula", new Peliculas());
        return "administrador/crear_pelicula";

    }  
    
     @PostMapping("/admin/peliculas/save")
    public String guardarPeliculas(@ModelAttribute Peliculas peliculas) {
        peliculasService.savePeliculas(peliculas);
        return "redirect:/admin/peliculas";
    }
    
    @GetMapping("/admin/peliculas/editPeliculas/{id}")
    public String editarPeliculas(@PathVariable("id") Long idPeliculas, Model model) {
        Peliculas peliculas = peliculasService.getPeliculasById(idPeliculas);
        model.addAttribute("pelicula", peliculas);
        return "administrador/crear_pelicula";

    }
    @GetMapping("/admin/peliculas/delete/{id}")
    public String eliminarPeliculas(@PathVariable("id") Long idPeliculas, Model model) {
        peliculasService.delete(idPeliculas);
        return "redirect:/admin/peliculas";

    }
    
    
}
