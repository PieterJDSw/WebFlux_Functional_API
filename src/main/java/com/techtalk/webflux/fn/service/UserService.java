package com.techtalk.webflux.fn.service;

import com.techtalk.webflux.fn.dto.UserDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Flux<UserDto> findAllUsers();
    Mono<UserDto> findUserById(String id);

    Mono<UserDto> createUser(UserDto userDto);

}
