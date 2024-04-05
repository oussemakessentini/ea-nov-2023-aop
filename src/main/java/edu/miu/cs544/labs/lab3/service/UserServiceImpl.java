package edu.miu.cs544.labs.lab3.service;

import edu.miu.cs544.labs.lab3.entity.User;
import edu.miu.cs544.labs.lab3.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public void save(User address) {
        userRepo.save(address);
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void update(User address) {
        userRepo.save(address);
    }
}
