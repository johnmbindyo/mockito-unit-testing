/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.relationships.controllers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.school.relationships.entities.Teacher;
import com.school.relationships.models.TeacherModel;
import com.school.relationships.services.TeacherService;
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
@RequestMapping("/Teacher")
@Slf4j
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createTeacher(@RequestBody TeacherModel model) throws JsonProcessingException {
        Map<String, Object> responseMap = new HashMap<>();
        try {
            log.info("POST | Teacher Creation Operation = {}", model);
            responseMap.put("Status", "Success");
            teacherService.createTeacher(model);
            return ResponseEntity.ok(new ObjectMapper().writeValueAsString(responseMap));
        } catch (Exception e) {
            responseMap.put("Status", "Fail");
            responseMap.put("Message", e.getMessage());
            return new ResponseEntity<>(new ObjectMapper().writeValueAsString(responseMap), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
     @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findTeacher(@PathVariable Integer id) throws JsonProcessingException {
        Map<String, Object> responseMap = new HashMap<>();
        try {
            log.info("GET |Student Operation");
            Optional<Teacher> result = teacherService.findTeacherById(id);
            responseMap.put("Status", "Success");
            responseMap.put("Teacher", result.get());
            return ResponseEntity.ok(new ObjectMapper().writeValueAsString(responseMap));
        } catch (Exception e) {
            responseMap.put("Status", "Fail");
            responseMap.put("Message", e.getMessage());
            return new ResponseEntity<>(new ObjectMapper().writeValueAsString(responseMap), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
    @GetMapping(value = "/Subjects/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findSubjectsByTeacher(@PathVariable Integer id) throws JsonProcessingException {
        Map<String, Object> responseMap = new HashMap<>();
        try {
            log.info("GET |Student Operation");
            Optional<Teacher> result = teacherService.findTeacherAndSubjectsTaught(id);
            responseMap.put("Status", "Success");
            responseMap.put("Teacher's Subjects", result.get().getSubjectList());
            return ResponseEntity.ok(new ObjectMapper().writeValueAsString(responseMap));
        } catch (Exception e) {
            responseMap.put("Status", "Fail");
            responseMap.put("Message", e.getMessage());
            return new ResponseEntity<>(new ObjectMapper().writeValueAsString(responseMap), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
