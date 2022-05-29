/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.relationships.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "student_has_subject")
@XmlRootElement
public class StudentHasSubject implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private StudentHasSubjectPK studentHasSubjectPK;

    public StudentHasSubject() {
    }

    /**
     * @return the studentHasSubjectPK
     */
    public StudentHasSubjectPK getStudentHasSubjectPK() {
        return studentHasSubjectPK;
    }

    /**
     * @param studentHasSubjectPK the studentHasSubjectPK to set
     */
    public void setStudentHasSubjectPK(StudentHasSubjectPK studentHasSubjectPK) {
        this.studentHasSubjectPK = studentHasSubjectPK;
    }
}
