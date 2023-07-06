package com.techtalk.webflux.fn.handler;

import com.techtalk.webflux.fn.dto.UserDto;
import com.techtalk.webflux.fn.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserHandler {
    private final UserServiceImpl userService;
    public Mono<ServerResponse> listUsers(ServerRequest serverRequest) {
        Flux<UserDto> allPosts = userService.findAllUsers();
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(allPosts, UserDto.class)
                .switchIfEmpty(notFound);
    }
    public Mono<ServerResponse> findUserByID(ServerRequest serverRequest) {
        Mono<UserDto> user = userService.findUserById(serverRequest.pathVariable("userId"));
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(user, UserDto.class)
                .switchIfEmpty(notFound);
    }
    public Mono<ServerResponse> saveUser(ServerRequest serverRequest) {
        Mono<UserDto> userDtoMono = serverRequest.bodyToMono(UserDto.class);
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();

        return userDtoMono.flatMap(userDto ->
                        ServerResponse
                                .status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(userService.createUser(userDto), UserDto.class))
                .switchIfEmpty(notFound);
    }
}
