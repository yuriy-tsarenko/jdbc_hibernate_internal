package com.jdbc_hibernate_internal.homework.lesson2.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class EmployeeEntity {

    @SerializedName("employeeNumber")
    private Integer employeeNumber;

    @SerializedName("lastName")
    private String LastName;

    @SerializedName("firstName")
    private String firstName;

    @SerializedName("extension")
    private String extension;

    @SerializedName("email")
    private String email;

    @SerializedName("officeCode")
    private String officeCode;

    @SerializedName("reportsTo")
    private Integer reportsTo;

    @SerializedName("jobTitle")
    private String jobTitle;


}
