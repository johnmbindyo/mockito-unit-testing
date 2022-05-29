/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.relationships.entities;

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
@Table(name = "teacher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t"),
    @NamedQuery(name = "Teacher.findByIdteacher", query = "SELECT t FROM Teacher t WHERE t.idteacher = :idteacher"),
    @NamedQuery(name = "Teacher.findByFullName", query = "SELECT t FROM Teacher t WHERE t.fullName = :fullName"),
    @NamedQuery(name = "Teacher.findByTeacherNo", query = "SELECT t FROM Teacher t WHERE t.teacherNo = :teacherNo")})
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idteacher")
    private Integer idteacher;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "teacher_no")
    private String teacherNo;
    @JsonIgnore
    @ManyToMany(mappedBy = "teacherList", fetch = FetchType.LAZY)
    private List<Subject> subjectList;

    public Teacher() {
    }

    public Teacher(Integer idteacher) {
        this.idteacher = idteacher;
    }

    public Integer getIdteacher() {
        return idteacher;
    }

    public void setIdteacher(Integer idteacher) {
        this.idteacher = idteacher;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
    }

    @XmlTransient
    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idteacher != null ? idteacher.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.idteacher == null && other.idteacher != null) || (this.idteacher != null && !this.idteacher.equals(other.idteacher))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.elearning.elearningentities.Teacher[ idteacher=" + idteacher + " ]";
    }
    
}
