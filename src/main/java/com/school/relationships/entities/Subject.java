/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.relationships.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "subject")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subject.findAll", query = "SELECT s FROM Subject s"),
    @NamedQuery(name = "Subject.findByIdsubject", query = "SELECT s FROM Subject s WHERE s.idsubject = :idsubject"),
    @NamedQuery(name = "Subject.findBySubjectname", query = "SELECT s FROM Subject s WHERE s.subjectname = :subjectname")})
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsubject")
    private Integer idsubject;
    @Column(name = "subjectname")
    private String subjectname;
   //@JsonBackReference
    @JsonIgnore
    @ManyToMany(mappedBy = "subjectList", fetch = FetchType.LAZY)
    private List<Student> studentList;
    @JsonIgnore
    @JoinTable(name = "teacher_has_subject", joinColumns = {
        @JoinColumn(name = "subject_idsubject", referencedColumnName = "idsubject")}, inverseJoinColumns = {
        @JoinColumn(name = "teacher_idteacher", referencedColumnName = "idteacher")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Teacher> teacherList;

    public Subject() {
    }

    public Subject(Integer idsubject) {
        this.idsubject = idsubject;
    }

    public Integer getIdsubject() {
        return idsubject;
    }

    public void setIdsubject(Integer idsubject) {
        this.idsubject = idsubject;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    @XmlTransient
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @XmlTransient
    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsubject != null ? idsubject.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subject)) {
            return false;
        }
        Subject other = (Subject) object;
        if ((this.idsubject == null && other.idsubject != null) || (this.idsubject != null && !this.idsubject.equals(other.idsubject))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.elearning.elearningentities.Subject[ idsubject=" + idsubject + " ]";
    }
    
}
