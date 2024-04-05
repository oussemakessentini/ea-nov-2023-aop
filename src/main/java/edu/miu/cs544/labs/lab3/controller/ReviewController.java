package edu.miu.cs544.labs.lab3.controller;

import edu.miu.cs544.labs.lab3.entity.Review;
import edu.miu.cs544.labs.lab3.service.ReviewService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/review")
@Tag(name = "Reviews", description = "Reviews API")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/")
    public List<Review> getAllReviews() {
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    public Review findById(@PathVariable Long id) {
        return reviewService.findById(id).orElse(null);
    }

    @PostMapping("/")
    public void save(Review review) {
        reviewService.save(review);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reviewService.delete(id);
    }

    @PutMapping("/")
    public void update(@RequestBody Review review) {
        reviewService.update(review);
    }
}
