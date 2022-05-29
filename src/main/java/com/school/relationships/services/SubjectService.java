/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.relationships.services;

import com.school.relationships.entities.Subject;
import com.school.relationships.models.SubjectModel;
import com.school.relationships.repositories.SubjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@Slf4j
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public Integer createSubject(SubjectModel model) {
        try {
            Subject subject = new Subject();
            subject.setSubjectname(model.getSubjectName());
           return subjectRepository.save(subject).getIdsubject();
        } catch (Exception e) {
            log.error("Error creating subject > {}", e);
            throw e;
        }
    }
    
    
}
