/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.relationships.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author hp
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentModel {

    @JsonProperty("Surname")
    private String surname;
    @JsonProperty("Firstname")
    private String firstname;
    @JsonProperty("Lastname")
    private String lasttname;
    @JsonProperty("Dob")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    @JsonProperty("FileNumber")
    private Integer admissionFileNo;
    @JsonProperty("DormitoryNumber")
    private Integer dormitoryNo;
}
