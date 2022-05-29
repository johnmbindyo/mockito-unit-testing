/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.relationships.repositories;

import com.school.relationships.entities.Dormitory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hp
 */
@Repository
public interface DormitoryRepository extends CrudRepository<Dormitory, Integer>{
    
}
