/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.controller;

import com.cine.entity.Cartelera;
import com.cine.entity.Peliculas;
import com.cine.service.ICarteleraService;
import com.cine.service.IHorarioService;
import com.cine.service.IPeliculasService;
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
public class CarteleraController {

    @Autowired
    private ICarteleraService carteleraService;

    @Autowired
    private IHorarioService horarioService;

    @Autowired
    private ISalasService salasService;

    @Autowired
    private IPeliculasService peliculasService;

    @GetMapping("/cartelera")
    public String index(Model model) {
        model.addAttribute("titulo", "Tabla Cartelera");
        model.addAttribute("cartelera", carteleraService.getAllCarteleraActivas());
        return "cartelera_publico";
    }

    @GetMapping("/cartelera/admin")
    public String crearPeliculas(Model model) {
        model.addAttribute("titulo", "Tabla Cartelera");
        model.addAttribute("cartelera", carteleraService.getAllCartelera());
        return "cartelera";

    }

    @GetMapping("/cartelera/crear")
    public String crearCartelera(Model model) {
        model.addAttribute("pelicula", new Peliculas());
        model.addAttribute("peliculas", peliculasService.getAllPeliculas());
        model.addAttribute("salas", salasService.getAllSalas());
        model.addAttribute("horarios", horarioService.getAllHorario());
        model.addAttribute("titulo", "Agregar a Cartelera");
        return "crear_cartelera";

    }

    @PostMapping("/cartelera/save")
    public String guardarCartelera(@ModelAttribute Cartelera cartelera) {
        carteleraService.saveCartelera(cartelera);
        return "redirect:/cartelera/admin";
    }

    @GetMapping("/cartelera/editCartelera/{id}")
    public String editarCartelera(@PathVariable("id") Long idCartelera, Model model) {
        Cartelera cartelera = carteleraService.getCarteleraById(idCartelera);
        model.addAttribute("cartelera", cartelera);
        model.addAttribute("peliculas", peliculasService.getAllPeliculas());
        model.addAttribute("salas", salasService.getAllSalas());
        model.addAttribute("horarios", horarioService.getAllHorario());
        model.addAttribute("titulo", "Editar Cartelera");
        return "crear_cartelera";

    }

    @GetMapping("/cartelera/delete/{id}")
    public String eliminarCartelera(@PathVariable("id") Long idCartelera, Model model) {
        peliculasService.delete(idCartelera);
        return "redirect:/cartelera/admin";

    }

}
