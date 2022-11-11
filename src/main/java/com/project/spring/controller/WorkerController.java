/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.spring.controller;

import com.project.spring.dto.WorkerDto;
import com.project.spring.model.DepartamentModel;
import com.project.spring.model.WorkerModel;
import com.project.spring.service.WorkerService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sscos
 */
@RestController
@RequestMapping("/worker")
@CrossOrigin(origins = "*")
public class WorkerController {
    
    @Autowired
    WorkerService workerService;
    
    @PostMapping
    public ResponseEntity<Object> insertWorker(@RequestBody @Valid WorkerDto workerDto){
            WorkerModel workerModel = new WorkerModel();
            BeanUtils.copyProperties(workerDto, workerModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(workerService.save(workerModel));
    }
    
    @GetMapping
    public ResponseEntity<List<WorkerModel>> getWorkers(){
        List<WorkerModel> workers = workerService.findAll();
        DepartamentModel departament;
        if(workerService.findAll().toString().isBlank()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        for(WorkerModel worker : workers)
        {
            departament = worker.getDepartament();
            departament.add(linkTo(methodOn(DepartamentController.class).getDepartament(departament.getDepartament_id())).withSelfRel());
            worker.add(linkTo(methodOn(WorkerController.class).getWorker(worker.getId())).withSelfRel());
        }
        return ResponseEntity.status(HttpStatus.OK).body(workerService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getWorker(@PathVariable(value = "id") long id){
        Optional<WorkerModel> workerModelOptional = workerService.findById(id);
        if(!workerModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe esse trabalhador!");
        }
        DepartamentModel departament = workerModelOptional.get().getDepartament();
        departament.add(linkTo(methodOn(DepartamentController.class).getDepartament(departament.getDepartament_id())).withSelfRel());
        workerModelOptional.get().add(linkTo(methodOn(WorkerController.class).deleteWorker(id)).withRel("Deletar").withType("DELETE"));
        workerModelOptional.get().add(linkTo(methodOn(WorkerController.class).updateWorker(id, null)).withRel("Editar").withType("PUT"));
        return ResponseEntity.status(HttpStatus.OK).body(workerService.findById(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateWorker(@PathVariable(value = "id") long id, @RequestBody @Valid WorkerDto workerDto){
        
        Optional<WorkerModel> workerModelOptional = workerService.findById(id);
        if(!workerModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe esse trabalhador!");
        }
            WorkerModel workerModel = new WorkerModel();
            BeanUtils.copyProperties(workerDto, workerModel);
            workerModel.setId(workerModelOptional.get().getId());
            return ResponseEntity.status(HttpStatus.OK).body(workerService.save(workerModel));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteWorker(@PathVariable(value = "id") long id){
        Optional<WorkerModel> workerModelOptional = workerService.findById(id);
        if(!workerModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe esse trabalhador!");
        }
        
        workerService.DeleteById(workerModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body("Trabalhador deletado!");
    }
    
    
}
