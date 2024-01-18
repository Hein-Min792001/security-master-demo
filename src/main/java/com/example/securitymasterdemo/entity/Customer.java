package com.example.securitymasterdemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Code cannot be Empty!")
    @Size(min = 2,max = 5
    ,message = "Code must between 2 and 5")
    @Pattern(regexp = "[A-za-z]*",message = "Code cannot contain illegal characters")
    private String code;
    @NotBlank(message = "first name cannot be blank!")
    @Pattern(regexp = "[A-za-z]*",message = "first name cannot contain illegal characters")
    private String firstName;
    @NotBlank(message = "last name cannot be blank!")
    @Pattern(regexp = "[A-za-z]*",message = "last name cannot contain illegal characters")
    private String lastName;
    @NotBlank(message = "Address cannot be blank!")
    @Pattern(regexp = "[\\w.\\-/,]*",message = "Address cannot cannot contain illegal characters")
    private String address;
}
