/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.relationships.services;

import com.school.relationships.entities.Dormitory;
import com.school.relationships.models.DormitoryModel;
import com.school.relationships.repositories.DormitoryRepository;
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
public class DormitoryService {

    @Autowired
    private DormitoryRepository dormitoryRepository;

    public Integer createDormitory(DormitoryModel model) {
        try {
            Dormitory dormitory = new Dormitory();
            dormitory.setDormitoryname(model.getDormitoryName());
            dormitory.setNoOfWings(model.getNoOfWings());
            return dormitoryRepository.save(dormitory).getIddormitory();
        } catch (Exception e) {
            log.info("Error creating dormitory > {}", e);
            throw e;
        }
    }

    public Optional<Dormitory> findDormitoryById(Integer iddormitory) {
        return dormitoryRepository.findById(iddormitory);
    }
}
