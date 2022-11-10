/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.spring.dto;

import javax.validation.constraints.NotEmpty;

/**
 *
 * @author sscos
 */
public class DepartamentDto {
    
    @NotEmpty
    private String DepartamentNome;
    
    public String getNome() {
        return DepartamentNome;
    }

    public void setNome(String Nome) {
        this.DepartamentNome = Nome;
    }
}
