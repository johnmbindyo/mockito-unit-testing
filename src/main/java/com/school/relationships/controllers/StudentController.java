/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.relationships.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.school.relationships.entities.Student;
import com.school.relationships.models.StudentModel;
import com.school.relationships.services.StudentService;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hp
 */
@RestController
@RequestMapping("/Student")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createStudent(@RequestBody StudentModel model) throws JsonProcessingException {
        Map<String, Object> responseMap = new HashMap<>();
        try {
            log.info("POST | Student Creation Operation = {}", model);
            responseMap.put("Status", "Success");
            studentService.createStudent(model);            
            return ResponseEntity.ok(new ObjectMapper().writeValueAsString(responseMap));
        } catch (Exception e) {
            responseMap.put("Status", "Fail");
            responseMap.put("Message", e.getMessage());
            return new ResponseEntity<>(new ObjectMapper().writeValueAsString(responseMap), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
    @GetMapping(value = "/Subjects/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> subjectList(@PathVariable Integer id) throws JsonProcessingException {
        Map<String, Object> responseMap = new HashMap<>();
        try {
            log.info("GET |Student Subjects Operation");
            Optional<Student> result = studentService.findStudentWithTheirSubjects(id);
            responseMap.put("Status", "Success");
            responseMap.put("Student's Subjects", result.get().getSubjectList());
            return ResponseEntity.ok(new ObjectMapper().writeValueAsString(responseMap));
        } catch (Exception e) {
            responseMap.put("Status", "Fail");
            responseMap.put("Message", e.getMessage());
            return new ResponseEntity<>(new ObjectMapper().writeValueAsString(responseMap), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
     @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findStudent(@PathVariable Integer id) throws JsonProcessingException {
        Map<String, Object> responseMap = new HashMap<>();
        try {
            log.info("GET |Student Operation");
            Optional<Student> result = studentService.findStudentById(id);
            responseMap.put("Status", "Success");
            responseMap.put("Student", result.get());
            return ResponseEntity.ok(new ObjectMapper().writeValueAsString(responseMap));
        } catch (Exception e) {
            responseMap.put("Status", "Fail");
            responseMap.put("Message", e.getMessage());
            return new ResponseEntity<>(new ObjectMapper().writeValueAsString(responseMap), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
