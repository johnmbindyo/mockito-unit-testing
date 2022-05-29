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
@Table(name = "dormitory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dormitory.findAll", query = "SELECT d FROM Dormitory d"),
    @NamedQuery(name = "Dormitory.findByIddormitory", query = "SELECT d FROM Dormitory d WHERE d.iddormitory = :iddormitory"),
    @NamedQuery(name = "Dormitory.findByDormitoryname", query = "SELECT d FROM Dormitory d WHERE d.dormitoryname = :dormitoryname"),
    @NamedQuery(name = "Dormitory.findByNoOfWings", query = "SELECT d FROM Dormitory d WHERE d.noOfWings = :noOfWings")})
public class Dormitory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddormitory")
    private Integer iddormitory;    
    @Column(name = "dormitoryname")
    private String dormitoryname;
    @Column(name = "no_of_wings")
    private Integer noOfWings;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dormitoryIddormitory", fetch = FetchType.LAZY)
    private List<Student> studentList;

    public Dormitory() {
    }

    public Dormitory(Integer iddormitory) {
        this.iddormitory = iddormitory;
    }

    public Integer getIddormitory() {
        return iddormitory;
    }

    public void setIddormitory(Integer iddormitory) {
        this.iddormitory = iddormitory;
    }

    public String getDormitoryname() {
        return dormitoryname;
    }

    public void setDormitoryname(String dormitoryname) {
        this.dormitoryname = dormitoryname;
    }

    public Integer getNoOfWings() {
        return noOfWings;
    }

    public void setNoOfWings(Integer noOfWings) {
        this.noOfWings = noOfWings;
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
        hash += (iddormitory != null ? iddormitory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dormitory)) {
            return false;
        }
        Dormitory other = (Dormitory) object;
        if ((this.iddormitory == null && other.iddormitory != null) || (this.iddormitory != null && !this.iddormitory.equals(other.iddormitory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.elearning.elearningentities.Dormitory[ iddormitory=" + iddormitory + " ]";
    }
    
}
