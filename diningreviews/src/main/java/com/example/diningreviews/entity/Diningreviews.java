package com.example.diningreviews.entity;

import com.example.diningreviews.entity.Restaurant;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table(name = "DININGREVIEWS")
@Data
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Diningreviews that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getUserName(), that.getUserName()) && Objects.equals(getRestaurantId(), that.getRestaurantId()) && Objects.equals(getPeanutScore(), that.getPeanutScore()) && Objects.equals(getEggScore(), that.getEggScore()) && Objects.equals(getDairyScore(), that.getDairyScore()) && Objects.equals(getCommentary(), that.getCommentary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserName(), getRestaurantId(), getPeanutScore(), getEggScore(), getDairyScore(), getCommentary());
    }


    // as a good practice



}