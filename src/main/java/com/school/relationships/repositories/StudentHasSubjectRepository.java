/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.relationships.repositories;

import com.school.relationships.entities.StudentHasSubject;
import com.school.relationships.entities.StudentHasSubjectPK;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hp
 */
@Repository
public interface StudentHasSubjectRepository extends CrudRepository<StudentHasSubject, StudentHasSubjectPK> {

  
}
