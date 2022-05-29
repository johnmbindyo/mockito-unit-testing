/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.relationships.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "teacher_has_subject")
@XmlRootElement
public class TeacherHasSubject implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private TeacherHasSubjectPK teacherHasSubjectPK;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.teacherHasSubjectPK);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TeacherHasSubject other = (TeacherHasSubject) obj;
        if (!Objects.equals(this.teacherHasSubjectPK, other.teacherHasSubjectPK)) {
            return false;
        }
        return true;
    }

    /**
     * @return the teacherHasSubjectPK
     */
    public TeacherHasSubjectPK getTeacherHasSubjectPK() {
        return teacherHasSubjectPK;
    }

    /**
     * @param teacherHasSubjectPK the teacherHasSubjectPK to set
     */
    public void setTeacherHasSubjectPK(TeacherHasSubjectPK teacherHasSubjectPK) {
        this.teacherHasSubjectPK = teacherHasSubjectPK;
    }
}
