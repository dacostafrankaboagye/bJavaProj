package com.example.diningreviews.repository;

import com.example.diningreviews.entity.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
//    public List<Restaurant> findByReviewScoresIsNotNullOrderByReviewScoresDesc();
//    public List<Restaurant> findByReviewScoresIsNotNullAndUserZipcodeOrderByReviewScoresDesc(String zipcode);

}
