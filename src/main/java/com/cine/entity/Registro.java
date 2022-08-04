/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author AMCG_
 */
@Entity
@Table(name = "usuarios")
public class Registro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String correo;
    private String contrasena;
    private String rol = "";
    private int active;
    private String permisos= "";
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String email) {
        this.correo = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String password) {
        this.contrasena = password;
    }

    public List<String> getRolList() {
        if(this.rol.length() > 0){
        return Arrays.asList(this.rol.split(","));
    }
        return new ArrayList<>();
    }

   

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public List<String> getPermisos() {
            if(this.permisos.length() > 0){
        return Arrays.asList(this.permisos.split(",")); 
    }
        return new ArrayList<>();
    }

}
