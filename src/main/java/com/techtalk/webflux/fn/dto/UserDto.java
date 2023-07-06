package com.techtalk.webflux.fn.dto;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {


    private String id;
    private String name;
    private Integer age;
    private String email;
}
