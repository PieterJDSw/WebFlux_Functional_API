package com.techtalk.webflux.fn.repository;

import com.techtalk.webflux.fn.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User, String> {
}
