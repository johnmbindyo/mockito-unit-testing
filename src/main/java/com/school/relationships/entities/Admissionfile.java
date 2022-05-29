/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.relationships.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "admissionfile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Admissionfile.findAll", query = "SELECT a FROM Admissionfile a"),
    @NamedQuery(name = "Admissionfile.findByIdadmissionfile", query = "SELECT a FROM Admissionfile a WHERE a.idadmissionfile = :idadmissionfile"),
    @NamedQuery(name = "Admissionfile.findByLeavingCertificate", query = "SELECT a FROM Admissionfile a WHERE a.leavingCertificate = :leavingCertificate"),
    @NamedQuery(name = "Admissionfile.findByGuardian1Name", query = "SELECT a FROM Admissionfile a WHERE a.guardian1Name = :guardian1Name"),
    @NamedQuery(name = "Admissionfile.findByGuadian1ContactInfo", query = "SELECT a FROM Admissionfile a WHERE a.guadian1ContactInfo = :guadian1ContactInfo"),
    @NamedQuery(name = "Admissionfile.findByGuardian2Name", query = "SELECT a FROM Admissionfile a WHERE a.guardian2Name = :guardian2Name"),
    @NamedQuery(name = "Admissionfile.findByGuadian2ContactInfo", query = "SELECT a FROM Admissionfile a WHERE a.guadian2ContactInfo = :guadian2ContactInfo"),
    @NamedQuery(name = "Admissionfile.findByPreviousSchool", query = "SELECT a FROM Admissionfile a WHERE a.previousSchool = :previousSchool"),
    @NamedQuery(name = "Admissionfile.findByPreviousSchoolLeavingDocument", query = "SELECT a FROM Admissionfile a WHERE a.previousSchoolLeavingDocument = :previousSchoolLeavingDocument"),
    @NamedQuery(name = "Admissionfile.findByMedicalDocument", query = "SELECT a FROM Admissionfile a WHERE a.medicalDocument = :medicalDocument")})
public class Admissionfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idadmissionfile")
    private Integer idadmissionfile;
    @Column(name = "leaving_certificate")
    private String leavingCertificate;
    @Column(name = "guardian_1_name")
    private String guardian1Name;
    @Column(name = "guadian_1_contact_info")
    private String guadian1ContactInfo;
    @Column(name = "guardian_2_name")
    private String guardian2Name;
    @Column(name = "guadian_2_contact_info")
    private String guadian2ContactInfo;
    @Column(name = "previous_school")
    private String previousSchool;
    @Column(name = "previous_school_leaving_document")
    private String previousSchoolLeavingDocument;
    @Column(name = "medical_document")
    private String medicalDocument;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fileNo", fetch = FetchType.LAZY)
    private List<Student> studentList;

    public Admissionfile() {
    }

    public Admissionfile(Integer idadmissionfile) {
        this.idadmissionfile = idadmissionfile;
    }

    public Integer getIdadmissionfile() {
        return idadmissionfile;
    }

    public void setIdadmissionfile(Integer idadmissionfile) {
        this.idadmissionfile = idadmissionfile;
    }

    public String getLeavingCertificate() {
        return leavingCertificate;
    }

    public void setLeavingCertificate(String leavingCertificate) {
        this.leavingCertificate = leavingCertificate;
    }

    public String getGuardian1Name() {
        return guardian1Name;
    }

    public void setGuardian1Name(String guardian1Name) {
        this.guardian1Name = guardian1Name;
    }

    public String getGuadian1ContactInfo() {
        return guadian1ContactInfo;
    }

    public void setGuadian1ContactInfo(String guadian1ContactInfo) {
        this.guadian1ContactInfo = guadian1ContactInfo;
    }

    public String getGuardian2Name() {
        return guardian2Name;
    }

    public void setGuardian2Name(String guardian2Name) {
        this.guardian2Name = guardian2Name;
    }

    public String getGuadian2ContactInfo() {
        return guadian2ContactInfo;
    }

    public void setGuadian2ContactInfo(String guadian2ContactInfo) {
        this.guadian2ContactInfo = guadian2ContactInfo;
    }

    public String getPreviousSchool() {
        return previousSchool;
    }

    public void setPreviousSchool(String previousSchool) {
        this.previousSchool = previousSchool;
    }

    public String getPreviousSchoolLeavingDocument() {
        return previousSchoolLeavingDocument;
    }

    public void setPreviousSchoolLeavingDocument(String previousSchoolLeavingDocument) {
        this.previousSchoolLeavingDocument = previousSchoolLeavingDocument;
    }

    public String getMedicalDocument() {
        return medicalDocument;
    }

    public void setMedicalDocument(String medicalDocument) {
        this.medicalDocument = medicalDocument;
    }

    @XmlTransient
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idadmissionfile != null ? idadmissionfile.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admissionfile)) {
            return false;
        }
        Admissionfile other = (Admissionfile) object;
        if ((this.idadmissionfile == null && other.idadmissionfile != null) || (this.idadmissionfile != null && !this.idadmissionfile.equals(other.idadmissionfile))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.elearning.elearningentities.Admissionfile[ idadmissionfile=" + idadmissionfile + " ]";
    }

}
