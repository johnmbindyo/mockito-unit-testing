/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.relationships.services;

import com.school.relationships.entities.StudentHasSubject;
import com.school.relationships.entities.StudentHasSubjectPK;
import com.school.relationships.models.StudentHasSubjectModel;
import com.school.relationships.repositories.StudentHasSubjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@Slf4j
public class StudentSubjectService {

    @Autowired
    private StudentHasSubjectRepository studentHasSubjectRepository;

    public StudentHasSubjectPK addStudentSubject(StudentHasSubjectModel model) {
        try {
            StudentHasSubjectPK pK = new StudentHasSubjectPK();
            pK.setStudentID(model.getStudentAdmissionNumber());
            pK.setSubjectID(model.getSubjectID());
            StudentHasSubject studentHasSubject = new StudentHasSubject();
            studentHasSubject.setStudentHasSubjectPK(pK);
            return studentHasSubjectRepository.save(studentHasSubject).getStudentHasSubjectPK();
        } catch (Exception e) {
            log.info("Error adding student-subject record > {}", e);
           throw e;
        }
    }
}
