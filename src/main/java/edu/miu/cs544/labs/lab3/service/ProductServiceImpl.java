package edu.miu.cs544.labs.lab3.service;

import edu.miu.cs544.labs.lab3.entity.Product;
import edu.miu.cs544.labs.lab3.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo repo;

    @Override
    @EntityGraph(value = "Product.reviews")
    public List<Product> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Product> findById(long id) {
        return repo.findById(id);
    }

    @Override
    public void save(Product product) {
        repo.save(product);
    }

    @Override
    public void delete(long id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Product product) {
        repo.save(product);
    }
}
