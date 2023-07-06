package com.techtalk.webflux.fn.service;

import com.techtalk.webflux.fn.dto.UserDto;
import com.techtalk.webflux.fn.mapper.UserMapper;
import com.techtalk.webflux.fn.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@AllArgsConstructor

public class UserServiceImpl implements  UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Flux<UserDto> findAllUsers() {
        return null;
    }

    @Override
    public Mono<UserDto> findUserById(Integer id) {
        return null;
    }

    @Override
    public Mono<UserDto> createUser(UserDto userDto) {
        return null;
    }
}
