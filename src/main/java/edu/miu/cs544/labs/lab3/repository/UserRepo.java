package edu.miu.cs544.labs.lab3.repository;

import edu.miu.cs544.labs.lab3.entity.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends ListCrudRepository<User, Long> {

}
