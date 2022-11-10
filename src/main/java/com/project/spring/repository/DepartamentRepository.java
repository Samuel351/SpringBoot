/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.spring.repository;

import com.project.spring.model.DepartamentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sscos
 */
@Repository
public interface DepartamentRepository extends CrudRepository<DepartamentModel, Long> {
    
    boolean existsBydepartamentNome(final String departamentNome);
}
