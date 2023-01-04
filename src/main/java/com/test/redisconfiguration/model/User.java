package com.test.redisconfiguration.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@RedisHash("users")
public class User implements Serializable {
    @Id
    private long id;

    private String name;
    private int age;
}
