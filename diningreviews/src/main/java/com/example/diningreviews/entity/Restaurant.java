package com.example.diningreviews.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Map;
import java.util.Objects;

@Entity
@Table(name = "RESTAURANT")
@Data
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // the default
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ElementCollection // indicates that reviewScores is a collection of simple types (a map) rather than an entity
    @CollectionTable(name = "restaurant_scores")//  the elements of the reviewScores map will be stored in a separate table named "restaurant_scores"
    @MapKeyColumn(name = "score")// the keys of the reviewScores map (which represent the food allergy categories) will be stored in a column named "category".
    @Column(name = "REVIEW SCORES")
    private Map<String, Double> reviewScores;

    public Restaurant(){}

    public Restaurant(String name, Map<String, Double> reviewScores){
        this.name = name;
        this.reviewScores = reviewScores;
    }

    // as a good practice
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant that)) return false;
        return Objects.equals(this.getId(), that.getId()) &&
                Objects.equals(this.getName(), that.getName()) &&
                Objects.equals(this.getReviewScores(), that.getReviewScores());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getName(), this.getReviewScores());
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", reviewScores=" + this.getReviewScores() +
                '}';
    }
}
