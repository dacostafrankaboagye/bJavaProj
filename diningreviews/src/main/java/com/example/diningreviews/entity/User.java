package com.example.diningreviews.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "USER ENTITY")
@Data  // getter, setter, toString, equals, hashcode -> are provided
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "USERNAME", unique = true)
    private String userName;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "ZIPCODE")
    private String zipcode;

    @Column(name = "INTERESTED IN PEANUT ALLERGIES")
    private Boolean interestedInPeanutAllergies;

    @Column(name = "INTERESTED IN EGG ALLERGIES")
    private Boolean interestedInEggAllergies;

    @Column(name = "INTERESTED IN DAIRY ALLERGIES")
    private Boolean interestedInDairyAllergies;

    public User(){}

    public User(String userName, String city, String state, String zipcode, Boolean interestedInPeanutAllergies, Boolean interestedInEggAllergies, Boolean interestedInDairyAllergies) {
        this.userName = userName;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.interestedInPeanutAllergies = interestedInPeanutAllergies;
        this.interestedInEggAllergies = interestedInEggAllergies;
        this.interestedInDairyAllergies = interestedInDairyAllergies;
    }

}
