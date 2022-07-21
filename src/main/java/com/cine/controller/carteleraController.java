/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.controller;

import com.cine.entity.Cartelera;
import com.cine.service.ICarteleraService;
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
public class carteleraController {

    @Autowired
    private ICarteleraService carteleraService;

    @GetMapping("/cartelera_admin")
    public String index(Model model) {
        List<Cartelera> listaCartelera = carteleraService.getAllCartelera();
        model.addAttribute("titulo", "Tabla cartelera");
        model.addAttribute("cartelera", listaCartelera);
        return "cartelera";

    }

    @GetMapping("/cartelera/crear")
    public String crearPelicula(Model model) {
        model.addAttribute("cartelera", new Cartelera());
        return "crear_pelicula";

    }
        @PostMapping("/cartelera/save")
    public String guardarCartelera(@ModelAttribute Cartelera cartelera) {
        carteleraService.saveCartelera(cartelera);
        return "redirect:/cartelera";
    }
    
     @GetMapping("/cartelera/editCartelera/{id}")
    public String editarCartelera(@PathVariable("id") Long idCartelera, Model model) {
        Cartelera cartelera = carteleraService.getCarteleraById(idCartelera);
        model.addAttribute("cartelera", cartelera);
        return "crear_pelicula";

    }
    @GetMapping("/cartelera/delete/{id}")
    public String eliminarCartelera(@PathVariable("id") Long idCartelera, Model model) {
        carteleraService.delete(idCartelera);
        return "redirect:/cartelera";

    }
    
    
    
}
