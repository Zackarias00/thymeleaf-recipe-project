package com.liftoff.thymeleafrecipeproject.demo.data;


import com.liftoff.thymeleafrecipeproject.demo.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}