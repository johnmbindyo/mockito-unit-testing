/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.relationships.services;

import com.school.relationships.entities.Teacher;
import com.school.relationships.models.TeacherModel;
import com.school.relationships.repositories.TeacherRepository;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@Slf4j
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Integer createTeacher(TeacherModel model) {
        try {
            Teacher teacher = new Teacher();
            teacher.setFullName(model.getTeacherName());
            teacher.setTeacherNo(model.getTeacherNumber());
            return teacherRepository.save(teacher).getIdteacher();
        } catch (Exception e) {
            log.error("Error creating teacher > {}", e);
            throw e;
        }
    }

    public Optional<Teacher> findTeacherById(Integer idteacher) {
        return teacherRepository.findById(idteacher);
    }

    public Optional<Teacher> findTeacherAndSubjectsTaught(Integer idteacher) {
        return teacherRepository.findTeacherAndSubjectsTaught(idteacher);
    }
}
