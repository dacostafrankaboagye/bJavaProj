package com.example.diningreviews.entity;

import com.example.diningreviews.enums.ReviewStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DININGREVIEWS ENTITY")
@Data // getter, setter, toString, equals, hashcode -> are provided
public class Diningreviews {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "USERNAME")
    private String userName;

    @Column(name = "RESTAURANT ID")
    private Long restaurantId;

    @Column(name = "PEANUT SCORE")
    private Integer peanutScore;

    @Column(name = "EGGS CORE")
    private Integer eggScore;

    @Column(name = "DAIRY SCORE")
    private Integer dairyScore;

    @Column(name = "COMMENTARY")
    private String commentary;

    @Enumerated(EnumType.STRING)
    private ReviewStatus status;

    public Diningreviews() {
    }

    public Diningreviews(String userName,
                         Long restaurantId,
                         Integer peanutScore,
                         Integer eggScore,
                         Integer dairyScore,
                         String commentary) {
        this.userName = userName;
        this.restaurantId = restaurantId;
        this.peanutScore = peanutScore;
        this.eggScore = eggScore;
        this.dairyScore = dairyScore;
        this.commentary = commentary;
    }

}