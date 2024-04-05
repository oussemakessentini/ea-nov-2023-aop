package edu.miu.cs544.labs.lab3.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
