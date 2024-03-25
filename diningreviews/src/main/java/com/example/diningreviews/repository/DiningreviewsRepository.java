package com.example.diningreviews.repository;

import com.example.diningreviews.entity.Diningreviews;
import com.example.diningreviews.enums.ReviewStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiningreviewsRepository extends CrudRepository<Diningreviews, Integer> {
//    List<Diningreviews> findByStatus(ReviewStatus status);
}
