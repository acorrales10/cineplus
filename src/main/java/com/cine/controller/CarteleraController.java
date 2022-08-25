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
    
    @GetMapping("/proximos_Estrenos")
    public String proximosEstrenos(Model model) {
        model.addAttribute("titulo", "Tabla Cartelera");
        model.addAttribute("cartelera", carteleraService.getAllCarteleraPreventa());
        return "proximos_Estrenos";
    }

    @GetMapping("/admin/cartelera")
    public String carteleraAdmin(Model model) {
        model.addAttribute("titulo", "Cartelera");
        model.addAttribute("cartelera", carteleraService.getAllCartelera());
        return "administrador/cartelera";

    }

    @GetMapping("/admin/cartelera/crear")
    public String crearCartelera(Model model) {
        model.addAttribute("cartelera", new Cartelera());
        model.addAttribute("peliculas", peliculasService.getAllPeliculas());
        model.addAttribute("salas", salasService.getAllSalas());
        model.addAttribute("horarios", horarioService.getAllHorario());
        model.addAttribute("titulo", "Agregar a Cartelera");
        return "administrador/crear_cartelera";

    }

    @PostMapping("/admin/cartelera/save")
    public String guardarCartelera(@ModelAttribute Cartelera cartelera) {
        carteleraService.saveCartelera(cartelera);
        return "redirect:/admin/cartelera";
    }

    @GetMapping("/admin/cartelera/editCartelera/{id}")
    public String editarCartelera(@PathVariable("id") Long idCartelera, Model model) {
        Cartelera cartelera = carteleraService.getCarteleraById(idCartelera);
        model.addAttribute("cartelera", cartelera);
        model.addAttribute("peliculas", peliculasService.getAllPeliculas());
        model.addAttribute("salas", salasService.getAllSalas());
        model.addAttribute("horarios", horarioService.getAllHorario());
        model.addAttribute("titulo", "Editar Cartelera");
        return "administrador/crear_cartelera";

    }

    @GetMapping("/admin/cartelera/delete/{id}")
    public String eliminarCartelera(@PathVariable("id") Long idCartelera, Model model) {
        carteleraService.delete(idCartelera);
        return "redirect:/admin/cartelera";

    }

}
