/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.relationships.models;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class DormitoryModel {

    @JsonProperty("DormitoryName")
    private String dormitoryName;
    @JsonProperty("NoOfWings")
    private Integer noOfWings;
}
