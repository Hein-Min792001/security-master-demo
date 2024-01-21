package com.example.securitymasterdemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "first Name cannot be empty!")
    @Pattern(regexp = "[A-Za-z]*", message = "first name cannot contain illegal characters")
    private String firstName;
    @NotBlank(message = "last name cannot be empty!")
    @Pattern(regexp = "[A-Za-z]*", message = "last name cannot contain illegal characters")
    private String lastName;
    @NotBlank(message = "phone number cannot be empty")
    @Pattern(regexp = "[0-9\\-+]*", message = "phone number cannot contain illegal characters")
    private String phoneNumber;
    @NotBlank(message = "address cannot be empty")
    @Pattern(regexp = "[\\w .\\-/,]*", message = "Address cannot contain illegal characters")
    private String address;
    @NotBlank(message = "Cubicle cannot be empty!")
    @Pattern(regexp = "[A-Za-z0-9\\-]*", message = "cubicleNo cannot contain illegal characters")
    private String cubicleNo;
}

