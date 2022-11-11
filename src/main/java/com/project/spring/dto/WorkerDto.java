/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.spring.dto;

import com.project.spring.model.DepartamentModel;
import com.project.spring.model.WorkerModel;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


/**
 *
 * @author sscos
 */

public class WorkerDto {
    
    @NotEmpty
    private String Cargo;
    
    @NotEmpty
    @Email
    private String Email;
    
    @NotEmpty
    private String Nome;
    
    @NotNull
    private double Salario;
    
    private DepartamentModel departament_id;

    public WorkerDto(String Cargo, String Email, String Nome, double Salario, DepartamentModel departament_id) {
        this.Cargo = Cargo;
        this.Email = Email;
        this.Nome = Nome;
        this.Salario = Salario;
        this.departament_id = departament_id;
    }
    
    public WorkerDto(WorkerModel workerModel) {
        Cargo = workerModel.getCargo();
        Email = workerModel.getEmail();
        Nome = workerModel.getNome();
        departament_id = workerModel.getDepartament();
    }
    

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double Salario) {
        this.Salario = Salario;
    }

    public DepartamentModel getDepartament_id() {
        return departament_id;
    }

}
