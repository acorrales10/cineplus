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
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author AMCG_
 */
@Entity
@Table(name = "cartelera")
public class Cartelera implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double precio;
    private boolean activo;
    private boolean preventa;
    private boolean home;

    
    @ManyToOne
    @JoinColumn(name = "pelicula_id")
    private Peliculas peliculas;
    
    
    @ManyToOne
    @JoinColumn(name = "agenda_id")
    private Horario horario;
    
    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Salas salas;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Peliculas getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(Peliculas peliculas) {
        this.peliculas = peliculas;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Salas getSalas() {
        return salas;
    }

    public void setSalas(Salas salas) {
        this.salas = salas;
    }
    
    public boolean isPreventa() {
        return preventa;
    }

    public void setPreventa(boolean preventa) {
        this.preventa = preventa;
    }

    public boolean isHome() {
        return home;
    }

    public void setHome(boolean home) {
        this.home = home;
    }
 
}