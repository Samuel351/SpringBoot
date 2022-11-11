/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.spring.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.hateoas.RepresentationModel;

/**
 *
 * @author sscos
 */
@Entity
@Table(name = "Worker")
public class WorkerModel extends RepresentationModel<WorkerModel> implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    private String Nome;
    
    private String Email;
    
    private String Cargo;
    
    private Double Salario;
    
    @ManyToOne
    @JoinColumn(name = "departament_id")
    private DepartamentModel Departament;
    
    public WorkerModel() {
    }

    public WorkerModel(String Nome, String Email, String Cargo, Double Salario, DepartamentModel departament_id) {
        this.Nome = Nome;
        this.Email = Email;
        this.Cargo = Cargo;
        this.Salario = Salario;
        this.Departament = departament_id;
    }
    
    public WorkerModel(int id, String Nome, String Email, String Cargo, Double Salario, DepartamentModel departament_id) {
        this.id = id;
        this.Nome = Nome;
        this.Email = Email;
        this.Cargo = Cargo;
        this.Salario = Salario;
        this.Departament = departament_id;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public Double getSalario() {
        return Salario;
    }

    public void setSalario(Double Salario) {
        this.Salario = Salario;
    }

    public DepartamentModel getDepartament() {
        return Departament;
    }

    public void setDepartament(DepartamentModel Departament) {
        this.Departament = Departament;
    }
   
}
