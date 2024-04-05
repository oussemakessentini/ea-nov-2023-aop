package edu.miu.cs544.labs.lab3.service;

import edu.miu.cs544.labs.lab3.entity.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    List<Review> findAll();

    Optional<Review> findById(Long id);

    void save(Review review);

    void delete(Long id);

    void update(Review review);

}
