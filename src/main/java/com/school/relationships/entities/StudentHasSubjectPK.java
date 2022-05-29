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
public class StudentHasSubjectPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "student_idstudent")
    private int studentID;

    @Basic(optional = false)
    @Column(name = "subject_idsubject")
    private int subjectID;

    public StudentHasSubjectPK() {
    }

    public StudentHasSubjectPK(int studentID, int subjectID) {
        this.studentID = studentID;
        this.subjectID = subjectID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.studentID;
        hash = 37 * hash + this.subjectID;
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
        final StudentHasSubjectPK other = (StudentHasSubjectPK) obj;
        if (this.studentID != other.studentID) {
            return false;
        }
        if (this.subjectID != other.subjectID) {
            return false;
        }
        return true;
    }

    /**
     * @return the studentID
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * @param studentID the studentID to set
     */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
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
