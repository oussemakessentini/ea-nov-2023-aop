package edu.miu.cs544.labs.lab3.controller;

import edu.miu.cs544.labs.lab3.aspect.ExecutionTime;
import edu.miu.cs544.labs.lab3.entity.User;
import edu.miu.cs544.labs.lab3.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
@Tag(name = "Users", description = "Users API")
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    @ExecutionTime
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @ExecutionTime
    public User findById(@PathVariable Long id) {
        return userService.findById(id).orElse(null);
    }

    @PostMapping("/")
    @ExecutionTime
    public void save(User user) {
        userService.save(user);
    }

    @DeleteMapping("/{id}")
    @ExecutionTime
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @PutMapping("/")
    @ExecutionTime
    public void update(@RequestBody User user) {
        userService.update(user);
    }

}
