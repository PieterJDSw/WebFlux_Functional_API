package com.techtalk.webflux.fn.config;


import com.techtalk.webflux.fn.handler.UserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class RouterConfig {
    public static final String USER_PATH ="/api/users";
    private final UserHandler userHandler;
    @Bean
    public RouterFunction<ServerResponse> userRoutes(){

        return route()
                .GET(USER_PATH,accept(APPLICATION_JSON), userHandler::listUsers)
                .GET(USER_PATH+"/{userId}",accept(APPLICATION_JSON), userHandler::findUserByID)
                .POST(USER_PATH,accept(APPLICATION_JSON), userHandler::saveUser)
                .build();
    }

    /*
    @Bean
	RouterFunction<ServerResponse> routes(PostHandler postHandler) {
		return
				nest(path("/api/posts"),
						nest(accept(MediaType.APPLICATION_JSON),
								route(method(HttpMethod.GET), postHandler::listPosts)
										.andRoute(DELETE("/{id}"), postHandler::deletePost)
										.andRoute(POST("/"), postHandler::savePost)
										.andRoute(PUT("/{id}"), postHandler::updatePost)));

	}
     */
}
