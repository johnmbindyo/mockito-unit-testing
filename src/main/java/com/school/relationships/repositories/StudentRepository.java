/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.relationships.repositories;

import com.school.relationships.entities.Student;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hp
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

    @Query("SELECT s FROM Student s JOIN FETCH s.subjectList  WHERE s.idstudent = :idstudent")
    public Optional<Student > findStudentAndSubjectsTaken(@Param("idstudent") Integer idstudent);
}
