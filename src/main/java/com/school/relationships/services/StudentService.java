/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.relationships.services;

import com.school.relationships.entities.Admissionfile;
import com.school.relationships.entities.Student;
import com.school.relationships.models.StudentModel;
import com.school.relationships.repositories.StudentRepository;
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
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private DormitoryService dormitoryService;
    @Autowired
    private AdmissionFileService admissionFileService;

    public void createStudent(StudentModel model) {
        try {
            Student student = new Student();
            Admissionfile file = admissionFileService.findAdmissionFileByFileNumber(model.getAdmissionFileNo()).get();
            student.setFileNo(file);
            student.setDob(model.getDateOfBirth());
            student.setFirstName(model.getFirstname());
            student.setSurname(model.getSurname());
            student.setLastName(model.getLasttname());
            student.setDormitoryIddormitory(dormitoryService.findDormitoryById(model.getDormitoryNo()).get());
            studentRepository.save(student);
        } catch (Exception e) {
            log.error("Error creating student > {}", e);
            throw e;
        }
    }

    public Optional<Student> findStudentWithTheirSubjects(Integer idstudent) {
        return studentRepository.findStudentAndSubjectsTaken(idstudent);
    }

    public Optional<Student> findStudentById(Integer idstudent) {
        return studentRepository.findById(idstudent);
    }

}
