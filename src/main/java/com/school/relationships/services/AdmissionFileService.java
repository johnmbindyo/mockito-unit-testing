/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.relationships.services;

import com.school.relationships.entities.Admissionfile;
import com.school.relationships.models.AdmissionFileModel;
import com.school.relationships.repositories.AdmissionfileRepository;
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
public class AdmissionFileService {

    @Autowired
    private AdmissionfileRepository admissionfileRepository;

    public Integer createAdmissionFile(AdmissionFileModel model) {
        try {
            Admissionfile file = new Admissionfile();
            file.setGuardian1Name(model.getGuardian1Name());
            file.setGuadian1ContactInfo(model.getGuardian1ContactInfo());
            file.setPreviousSchool(model.getPreviousSchool());
            return admissionfileRepository.save(file).getIdadmissionfile();
        } catch (Exception e) {
            log.error("Error creating admission file {}", e);
            throw e;
        }
    }

    public Optional<Admissionfile> findAdmissionFileByFileNumber(Integer idadmissionfile) {
        return admissionfileRepository.findById(idadmissionfile);
    }

}
