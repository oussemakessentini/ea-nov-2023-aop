package edu.miu.cs544.labs.lab3.service;

import edu.miu.cs544.labs.lab3.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(Long id);

    void save(User address);

    void delete(Long id);

    void update(User address);
}
