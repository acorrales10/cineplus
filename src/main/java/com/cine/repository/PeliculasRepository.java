/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cine.repository;

import com.cine.entity.Peliculas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AMCG_
 */
@Repository
public interface PeliculasRepository  extends CrudRepository<Peliculas,Long>{
    
}
