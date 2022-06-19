/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.relationships;

import com.school.relationships.entities.Teacher;
import com.school.relationships.models.TeacherModel;
import com.school.relationships.repositories.TeacherRepository;
import com.school.relationships.services.TeacherService;
import com.school.relationships.util.FormattingUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

/**
 *
 * @author hp
 */
@RunWith(MockitoJUnitRunner.class)
@Slf4j
public class TeacherServiceTests {

    @Mock
    private TeacherRepository teacherRepository;
    @Spy
    private FormattingUtils formattingUtils;
    @InjectMocks
    private TeacherService teacherService;

    @Test
    public void testCreateTeacherSuccessful() {
        log.info("Started testing method createTeacherSuccessful");
        Mockito.when(teacherRepository.save(Mockito.any(Teacher.class))).thenReturn(Mockito.mock(Teacher.class));
        TeacherModel model = new TeacherModel();
        model.setTeacherName("Mr. John");
        model.setTeacherNumber("123");
        teacherService.createTeacher(model);
        log.info("Finished testing method createTeacherSuccessful");
    }

    @Test
    public void testCreateTeacherSuccessfulWithFormattingUtilsModification() {

        log.info("Started testing method testCreateTeacherSuccessfulWithFormattingUtilsModification");
        Mockito.when(teacherRepository.save(Mockito.any(Teacher.class))).thenReturn(Mockito.mock(Teacher.class));
        Mockito.when(formattingUtils.formatTeacherNumber(Mockito.anyString())).thenAnswer((InvocationOnMock iom) -> {
            String trNo = iom.getArgument(0, String.class);
            return new StringBuilder().append("tr-").append(trNo.toLowerCase()).toString();
        });
        TeacherModel model = new TeacherModel();
        model.setTeacherName("Mr. John");
        model.setTeacherNumber("123");
        teacherService.createTeacher(model);
        log.info("Finished testing method testCreateTeacherSuccessfulWithFormattingUtilsModification");
    }
}
