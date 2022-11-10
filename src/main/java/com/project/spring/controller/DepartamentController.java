/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.spring.controller;

import com.project.spring.dto.DepartamentDto;
import com.project.spring.model.DepartamentModel;
import com.project.spring.service.DepartamentService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/departament")
public class DepartamentController {
    
    @Autowired
    DepartamentService departamentService;
    
    @PostMapping
    public ResponseEntity<Object> insertDepartament(@RequestBody @Valid DepartamentDto departamentDto){
        if(departamentService.existsBydepartamentNome(departamentDto.getNome()))
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe um departamento com este nome!");
        }
            DepartamentModel departamentModel = new DepartamentModel();
            BeanUtils.copyProperties(departamentDto, departamentModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(departamentService.save(departamentModel));
    }
    
    @GetMapping
    public ResponseEntity<List<DepartamentModel>> getDepartaments(){
        List<DepartamentModel> departaments = departamentService.findAll();
        if(departamentService.findAll().toString().isBlank()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        for(DepartamentModel departament : departaments)
        {
            long id = departament.getDepartament_id();
            departament.add(linkTo(methodOn(DepartamentController.class).getDepartament(id)).withSelfRel());
        }
        return ResponseEntity.status(HttpStatus.OK).body(departamentService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getDepartament(@PathVariable(value = "id") long id){
        
        Optional<DepartamentModel> departamentModelOptional = departamentService.findById(id);
        if(!departamentModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe esse departamento!");
        }
        departamentModelOptional.get().add(linkTo(methodOn(DepartamentController.class).deleteDepartament(id)).withRel("Deletar").withType("DELETE"));
        departamentModelOptional.get().add(linkTo(methodOn(DepartamentController.class).updateDepartament(id, null)).withRel("Editar").withType("PUT"));
        return ResponseEntity.status(HttpStatus.OK).body(departamentService.findById(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDepartament(@PathVariable(value = "id") long id, @RequestBody @Valid DepartamentDto departamentDto){
        
        Optional<DepartamentModel> departamentModelOptional = departamentService.findById(id);
        if(!departamentModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe esse departamento!");
        }
            DepartamentModel departamentModel = new DepartamentModel();
            BeanUtils.copyProperties(departamentDto, departamentModel);
            departamentModel.setDepartament_id(departamentModelOptional.get().getDepartament_id());
            return ResponseEntity.status(HttpStatus.OK).body(departamentService.save(departamentModel));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDepartament(@PathVariable(value = "id") long id){
        Optional<DepartamentModel> departamentModelOptional = departamentService.findById(id);
        if(!departamentModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe esse departamento!");
        }
        
        departamentService.DeleteById(departamentModelOptional.get().getDepartament_id());
        return ResponseEntity.status(HttpStatus.OK).body("Departamento deletado!");
    }
    
}
