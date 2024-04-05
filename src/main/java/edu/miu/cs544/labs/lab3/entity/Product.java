package edu.miu.cs544.labs.lab3.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@NamedEntityGraph(name = "Product.reviews",
        attributeNodes = @NamedAttributeNode("reviews")
)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @JsonManagedReference
    //@Fetch(FetchMode.SUBSELECT)
    //@Fetch(FetchMode.SELECT)
    //@Fetch(FetchMode.JOIN)
    @BatchSize(size = 200)
    private List<Review> reviews;

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
