/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cine.repository;

import com.cine.entity.Cartelera;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AMCG_
 */
@Repository
public interface CarteleraRepository extends CrudRepository<Cartelera,Long>{
    List<Cartelera> findAllByActivo(boolean activo);
    List<Cartelera> findAllByHome(boolean home);
    List<Cartelera> findAllByPreventa(boolean home);
    
}
