package edu.miu.cs544.labs.lab3.service;

import edu.miu.cs544.labs.lab3.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    Optional<Product> findById(long id);

    void save(Product product);

    void delete(long id);

    void update(Product product);
}
