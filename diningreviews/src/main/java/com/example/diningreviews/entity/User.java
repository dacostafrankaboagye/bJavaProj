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

    private String userName;
    private String city;
    private String state;
    private String zipcode;
    private Boolean interestedInPeanutAllergies;
    private Boolean interestedInEggAllergies;
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
