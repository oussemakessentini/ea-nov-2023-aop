package edu.miu.cs544.labs.lab3;

import edu.miu.cs544.labs.lab3.entity.Product;
import edu.miu.cs544.labs.lab3.entity.Review;
import edu.miu.cs544.labs.lab3.entity.User;
import edu.miu.cs544.labs.lab3.repository.ProductRepo;
import edu.miu.cs544.labs.lab3.repository.ReviewRepo;
import edu.miu.cs544.labs.lab3.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private ProductRepo productRepo;

    @Override
    public void run(String... args) throws Exception {
        List<User> users = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        // Seed users
        for (int i = 0; i < 100; i++) {
            int age = getRandomNumber(18, 60);
            User user = new User(String.format("User %s", i), age);
            userRepo.save(user);
            users.add(user);
        }

        // Seed products
        for (int i = 0; i < 1000; i++) {
            Product p = new Product(String.format("Product %s", i), String.format("Product %s description", i));
            productRepo.save(p);
            products.add(p);
        }

        // Seed reviews
        for (int i = 0; i < 1000; i++) {
            int rating = getRandomNumber(1, 6);
            int userIndex = i > 99 ? (i / 10) : i;
            Review review = new Review(
                    rating,
                    String.format("Comment %s", i),
                    users.get(userIndex),
                    products.get(i)
            );
            reviewRepo.save(review);
        }


    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
