/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.controller;

import com.cine.entity.Registro;
import com.cine.service.IRegistroService;
import com.cine.service.UserPrincipal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class RegistroController {

    @Autowired
    private IRegistroService registroService;

    @GetMapping("/admin/usuarios")
    public String index(Model model) {
        List<Registro> listaRegistro = registroService.getAllRegistro();
        model.addAttribute("titulo", "Tabla usuarios");
        model.addAttribute("registro", listaRegistro);
        return "administrador/registro";
    }

    @GetMapping("/usuarios/crear")
    public String crearPersona(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("autenticado? " + authentication.isAuthenticated());
        model.addAttribute("registro", new Registro());
        return "administrador/crear_usuario";

    }

    @PostMapping("/usuarios/save")
    public String guardarRegistro(@ModelAttribute Registro registro) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated()) {
            Object principal = SecurityContextHolder.getContext().getAuthentication();
            /// Asignar tiquete a usuario iniciado si hay sesion
            if (principal instanceof UserPrincipal) {
                registro.setPermisos(registro.getRol());
                registro.setActive(1);
            } else {
                
                registro.setPermisos("Cliente");
                registro.setRol("Cliente");
                registro.setActive(1);
            }
        }
        registroService.saveRegistro(registro);
        return "redirect:/login";
    }

    @GetMapping("/usuarios/editRegistro/{id}")
    public String editarRegistro(@PathVariable("id") Long idRegistro, Model model) {
        Registro registro = registroService.getRegistroById(idRegistro);
        model.addAttribute("registro", registro);
        return "crear_usuario";

    }

    @GetMapping("/usuarios/delete/{id}")
    public String eliminarRegistro(@PathVariable("id") Long idRegistro, Model model) {
        registroService.delete(idRegistro);
        return "redirect:/usuarios";

    }

}
