/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.spring.service;

import com.project.spring.model.WorkerModel;
import com.project.spring.repository.WorkerRepository;
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
public class WorkerService {
    
        
    @Autowired
    WorkerRepository workerRepository;
    
    @Transactional
    public WorkerModel save(WorkerModel workerModel){
        return workerRepository.save(workerModel);
    }
    
    public Optional <WorkerModel> findById(Long id){
        return workerRepository.findById(id);
    }
    
   
    public List<WorkerModel> findAll(){
        return (List<WorkerModel>) workerRepository.findAll();
    }
    
    @Transactional
    public void DeleteById(long id){
        workerRepository.deleteById(id);
    }
    
    
}
