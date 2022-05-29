/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.relationships.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.school.relationships.models.StudentHasSubjectModel;
import com.school.relationships.models.StudentModel;
import com.school.relationships.services.StudentSubjectService;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hp
 */
@RestController
@RequestMapping("/StudentHasSubject")
@Slf4j
public class StudentHasSubjectController {

    @Autowired
    private StudentSubjectService studentSubjectService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createStudentHasSubject(@RequestBody StudentHasSubjectModel model) throws JsonProcessingException {
        Map<String, Object> responseMap = new HashMap<>();
        try {
            log.info("POST | Student-Subject Creation Operation = {}", model);
            responseMap.put("Status", "Success");
            studentSubjectService.addStudentSubject(model);
            return ResponseEntity.ok(new ObjectMapper().writeValueAsString(responseMap));
        } catch (Exception e) {
            responseMap.put("Status", "Fail");
            responseMap.put("Message", e.getMessage());
            return new ResponseEntity<>(new ObjectMapper().writeValueAsString(responseMap), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
