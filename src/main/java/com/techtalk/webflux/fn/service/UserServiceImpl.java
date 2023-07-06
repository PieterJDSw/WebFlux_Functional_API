package com.techtalk.webflux.fn.service;

import com.techtalk.webflux.fn.dto.UserDto;
import com.techtalk.webflux.fn.entity.User;
import com.techtalk.webflux.fn.mapper.UserMapper;
import com.techtalk.webflux.fn.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;


@Service
@AllArgsConstructor

public class UserServiceImpl implements  UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Flux<UserDto> findAllUsers() {
        return userRepository.findAll()
                .map(userMapper::mapToUserDto)
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<UserDto> findUserById(String id) {
        return userRepository.findById(id)
                .map(userMapper::mapToUserDto)
                .switchIfEmpty(Mono.empty());

    }

    @Override
    public Mono<UserDto> createUser(UserDto userDto) {

        User user = userMapper.mapToUser(userDto);
        user.setCreatedOn(LocalDateTime.now());
        user.setUpdatedOn(LocalDateTime.now());
        return userRepository.save(user)
                .map(entry-> {
                    userDto.setId(entry.getId());
                    return userDto;

                });

    }
}
