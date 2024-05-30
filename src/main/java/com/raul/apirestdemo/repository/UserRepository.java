package com.sermaluc.apirestdemo.repository;

import com.sermaluc.apirestdemo.model.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
