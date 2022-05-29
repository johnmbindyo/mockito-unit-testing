/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.relationships.services;

import com.school.relationships.entities.TeacherHasSubject;
import com.school.relationships.entities.TeacherHasSubjectPK;
import com.school.relationships.models.TeacherHasSubjectModel;
import com.school.relationships.repositories.TeacherHasSubjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@Slf4j
public class TeacherSubjectService {

    @Autowired
    TeacherHasSubjectRepository teacherHasSubjectRepository;

    public TeacherHasSubjectPK addTeacherSubject(TeacherHasSubjectModel model) {
        try {
            TeacherHasSubjectPK pK = new TeacherHasSubjectPK();
            pK.setSubjectID(model.getSubjectID());
            pK.setTeacherID(model.getTeacherID());
            TeacherHasSubject teacherHasSubject = new TeacherHasSubject();
            teacherHasSubject.setTeacherHasSubjectPK(pK);
            return teacherHasSubjectRepository.save(teacherHasSubject).getTeacherHasSubjectPK();
        } catch (Exception e) {
            log.info("Error adding teacher-subject record > {}", e);
            throw e;
        }
    }
}
