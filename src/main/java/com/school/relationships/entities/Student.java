/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.relationships.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByIdstudent", query = "SELECT s FROM Student s WHERE s.idstudent = :idstudent"),
    @NamedQuery(name = "Student.findBySurname", query = "SELECT s FROM Student s WHERE s.surname = :surname"),
    @NamedQuery(name = "Student.findByFirstName", query = "SELECT s FROM Student s WHERE s.firstName = :firstName"),
    @NamedQuery(name = "Student.findByLastName", query = "SELECT s FROM Student s WHERE s.lastName = :lastName"),
    @NamedQuery(name = "Student.findByDob", query = "SELECT s FROM Student s WHERE s.dob = :dob")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idstudent")
    private Integer idstudent;
    @Column(name = "surname")
    private String surname;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "dob")    
    @Temporal(TemporalType.DATE)
    private Date dob;
    //@JsonManagedReference
    @JsonIgnore
    @JoinTable(name = "student_has_subject", joinColumns = {
        @JoinColumn(name = "student_idstudent", referencedColumnName = "idstudent")}, inverseJoinColumns = {
        @JoinColumn(name = "subject_idsubject", referencedColumnName = "idsubject")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Subject> subjectList;
    @JsonIgnore
    @JoinColumn(name = "file_no", referencedColumnName = "idadmissionfile")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Admissionfile fileNo;
    @JsonIgnore
    @JoinColumn(name = "dormitory_iddormitory", referencedColumnName = "iddormitory")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Dormitory dormitoryIddormitory;

    public Student() {
    }

    public Student(Integer idstudent) {
        this.idstudent = idstudent;
    }

    public Integer getIdstudent() {
        return idstudent;
    }

    public void setIdstudent(Integer idstudent) {
        this.idstudent = idstudent;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @XmlTransient
    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public Admissionfile getFileNo() {
        return fileNo;
    }

    public void setFileNo(Admissionfile fileNo) {
        this.fileNo = fileNo;
    }

    public Dormitory getDormitoryIddormitory() {
        return dormitoryIddormitory;
    }

    public void setDormitoryIddormitory(Dormitory dormitoryIddormitory) {
        this.dormitoryIddormitory = dormitoryIddormitory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idstudent != null ? idstudent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.idstudent == null && other.idstudent != null) || (this.idstudent != null && !this.idstudent.equals(other.idstudent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.elearning.elearningentities.Student[ idstudent=" + idstudent + " ]";
    }
    
}
