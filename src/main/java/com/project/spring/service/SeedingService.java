/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.spring.service;

import com.project.spring.model.DepartamentModel;
import com.project.spring.model.WorkerModel;
import com.project.spring.repository.DepartamentRepository;
import com.project.spring.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 * @author sscos
 */
@Component
public class SeedingService implements CommandLineRunner {
    
    @Autowired
    DepartamentRepository departamentRepository;
    
    @Autowired
    WorkerRepository workerRepository;

    @Override
    public void run(String... args) throws Exception {
       
        departamentRepository.save(new DepartamentModel("Vendas"));
        departamentRepository.save(new DepartamentModel("Financeiro"));
        departamentRepository.save(new DepartamentModel("Administrativo"));
        
        workerRepository.save(new WorkerModel("Samuel", "samuel@gmail.com", "Gerente de vendas", 2000.0, 
                new DepartamentModel(1, "")));
        workerRepository.save(new WorkerModel("Jefferson", "jeff@gmail.com", "Analista de riscos", 4000.0, 
                new DepartamentModel(2, "")));
        workerRepository.save(new WorkerModel("Ana clara", "ana@gmail.com", "Gerente de vendas", 2000.0, 
                new DepartamentModel(1, "")));
        workerRepository.save(new WorkerModel("Oliver", "oliver@gmail.com", "CEO", 20000.0, 
                new DepartamentModel(3, "")));
        workerRepository.save(new WorkerModel("Anderson", "anderson@gmail.com", "Auxiliar administrativo", 500.0, 
                new DepartamentModel(3, "")));
        
    }
    
}
