/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.relationships.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author hp
 */
@Embeddable
public class TeacherHasSubjectPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "teacher_idteacher")
    private int teacherID;

    @Basic(optional = false)
    @Column(name = "subject_idsubject")
    private int subjectID;

    public TeacherHasSubjectPK() {
    }

    public TeacherHasSubjectPK(int teacherID, int subjectID) {
        this.teacherID = teacherID;
        this.subjectID = subjectID;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.teacherID;
        hash = 97 * hash + this.subjectID;
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
        final TeacherHasSubjectPK other = (TeacherHasSubjectPK) obj;
        if (this.teacherID != other.teacherID) {
            return false;
        }
        if (this.subjectID != other.subjectID) {
            return false;
        }
        return true;
    }

    /**
     * @return the teacherID
     */
    public int getTeacherID() {
        return teacherID;
    }

    /**
     * @param teacherID the teacherID to set
     */
    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    /**
     * @return the subjectID
     */
    public int getSubjectID() {
        return subjectID;
    }

    /**
     * @param subjectID the subjectID to set
     */
    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

}
