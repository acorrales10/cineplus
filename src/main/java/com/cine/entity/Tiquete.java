/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cine.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author AMCG_
 */
@Entity
@Table(name = "tiquete")
public class Tiquete implements Serializable{
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String asiento_c;
    private String asiento_p;
    private String nombres;
    private String apellidos;
    private String email;
    private String direccion;
    private double total;
    private String codigo;
    
    @ManyToOne
    @JoinColumn(name = "cartelera_id")
    private Cartelera cartelera;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Registro registro;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAsientoC() {
        return asiento_c;
    }

    public void setAsientoC(String asiento_c) {
        this.asiento_c = asiento_c;
    }

    public String getAsientoP() {
        return asiento_p;
    }

    public void setAsientoP(String asiento_p) {
        this.asiento_p = asiento_p;
    }

    public Cartelera getCartelera() {
        return cartelera;
    }

    public void setCartelera(Cartelera cartelera) {
        this.cartelera = cartelera;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
    
   
    
}
