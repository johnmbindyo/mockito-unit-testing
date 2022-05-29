/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.relationships.repositories;

import com.school.relationships.entities.Teacher;
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
public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

    @Query("SELECT t FROM Teacher t JOIN FETCH t.subjectList  WHERE t.idteacher = :idteacher")
    public Optional<Teacher> findTeacherAndSubjectsTaught(@Param("idteacher") Integer idteacher);
}
