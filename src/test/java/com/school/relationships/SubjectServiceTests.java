/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.relationships;

import com.school.relationships.entities.Subject;
import com.school.relationships.models.SubjectModel;
import com.school.relationships.repositories.SubjectRepository;
import com.school.relationships.services.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author hp
 */
@RunWith(MockitoJUnitRunner.class)
@Slf4j
public class SubjectServiceTests {
    
    @Mock
    private SubjectRepository subjectRepository;
    @InjectMocks
    private SubjectService subjectService;
    
    @Test
    public void testCreateSubjectSuccessful() {
        log.info("Started testing method testCreateSubjectSuccessful");
        Mockito.when(subjectRepository.save(Mockito.any(Subject.class))).thenReturn(Mockito.mock(Subject.class)); 
          
        SubjectModel mockSubjectModel = new SubjectModel();
        mockSubjectModel.setSubjectName("Math");
        subjectService.createSubject(mockSubjectModel);
        log.info("Finished testing method testCreateSubjectSuccessful");
    }
    
    @Test(expected = NullPointerException.class)
    public void testCreateSubjectThrowsException() {
        log.info("Started testing method testCreateSubjectThrowsException");
        Mockito.when(subjectRepository.save(Mockito.any(Subject.class))).thenThrow(NullPointerException.class);           
        SubjectModel mockSubjectModel = new SubjectModel();
        mockSubjectModel.setSubjectName("Science");
        subjectService.createSubject(mockSubjectModel);
        log.info("Finished testing method testCreateSubjectThrowsException");
    }
    
    
}
