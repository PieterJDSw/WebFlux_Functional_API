package com.techtalk.webflux.fn.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class User {
    @Id
    private String id;
    private String name;
    private Integer age;
    private String email;
    @Field(name = "created_on")
    private LocalDateTime createdOn;
    @Field(name = "updated_on")
    private LocalDateTime updatedOn;
}
