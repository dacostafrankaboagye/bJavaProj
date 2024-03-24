package com.example.mySpringProject.peoples.entities;

import jakarta.persistence.Entity;
@Entity
public class People {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
}
