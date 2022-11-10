/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.spring.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.hateoas.RepresentationModel;

/**
 *
 * @author sscos
 */

@Entity
@Table(name = "Departament")
public class DepartamentModel  extends RepresentationModel<WorkerModel> implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long departament_id;
    
    private String departamentNome;
    

    public DepartamentModel() {
    }

    public DepartamentModel(String departamentNome) {
        this.departamentNome = departamentNome;
    }

    public DepartamentModel(long departament_id, String Nome) {
        this.departament_id = departament_id;
        this.departamentNome = Nome;
    }
    
    public long getDepartament_id() {
        return departament_id;
    }

    public void setDepartament_id(long departament_id) {
        this.departament_id = departament_id;
    }

    public String getNome() {
        return departamentNome;
    }

    public void setNome(String Nome) {
        this.departamentNome = Nome;
    } 
}
