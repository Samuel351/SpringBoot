/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.spring.service;

import com.project.spring.model.DepartamentModel;
import com.project.spring.repository.DepartamentRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sscos
 */
@Service
public class DepartamentService {
    
    @Autowired
    DepartamentRepository departamentRepository;
    
    @Transactional
    public DepartamentModel save(DepartamentModel departamentModel){
        return departamentRepository.save(departamentModel);
    }
    
    public Optional <DepartamentModel> findById(Long id){
        return departamentRepository.findById(id);
    }
    
    public List<DepartamentModel> findAll(){
        return (List<DepartamentModel>) departamentRepository.findAll();
    }
    
    @Transactional
    public void DeleteById(long id){
        departamentRepository.deleteById(id);
    }
    
    public boolean existsBydepartamentNome(String departamentNome){
        return departamentRepository.existsBydepartamentNome(departamentNome);
    }
    
}
