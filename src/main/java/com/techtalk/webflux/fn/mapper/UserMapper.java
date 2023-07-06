package com.techtalk.webflux.fn.mapper;


import com.techtalk.webflux.fn.dto.UserDto;
import com.techtalk.webflux.fn.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User mapToPost(UserDto userInput) {
        return User.builder().name(userInput.getName()).age(userInput.getAge()).email(userInput.getEmail()).build();

    }

    public UserDto mapToPostDto(User user) {
        return UserDto.builder()
                .id(user.getId()).name(user.getName()).age(user.getAge()).email(user.getEmail())
                .build();
    }
}
