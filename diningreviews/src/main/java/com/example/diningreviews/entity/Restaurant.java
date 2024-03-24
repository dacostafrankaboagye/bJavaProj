package com.example.diningreviews.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "RESTAURANT")
public class Restaurant {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @Column(name = "RESTAURANTNAME")
    @Getter
    @Setter
    private String restaurantName;

    @Column(name = "PEANUTSCORE")
    @Getter
    @Setter
    private Double peanutScore;


    @Column(name = "PEANUTNUMBER")
    @Getter
    @Setter
    private Double peanutNumber;

    @Column(name = "EGGSCORE")
    @Getter
    @Setter
    private Double eggScore;

    @Column(name = "EGGNUMBER")
    @Getter
    @Setter
    private Double eggNumber;

    @Column(name = "DIARYSCORE")
    private Double diaryScore;

    @Column(name = "DIARYNUMBER")
    @Getter
    @Setter
    private Double diaryNumber;

    @Column(name = "OVERALLSCORE")
    @Getter
    @Setter
    private Double overAllScore;


}
