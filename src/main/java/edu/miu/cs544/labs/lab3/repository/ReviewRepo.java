package edu.miu.cs544.labs.lab3.repository;

import edu.miu.cs544.labs.lab3.entity.Review;
import org.springframework.data.repository.ListCrudRepository;

public interface ReviewRepo extends ListCrudRepository<Review, Long> {
}
