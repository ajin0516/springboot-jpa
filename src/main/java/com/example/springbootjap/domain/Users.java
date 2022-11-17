package com.example.springbootjap.domain;


import com.example.springbootjap.domain.dto.UsersResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;


    /*
    요청-> 디비저장 -> 응답
    UsersRequestDto -> users(entity) -> UsersResponseDto
    users(entity) -> UsersResponseDto
    안정성 보장
     */

    public static UsersResponseDto of(Users users) {
        UsersResponseDto usersResponseDto = new UsersResponseDto(users.getId(), users.getUsername(), users.getPassword());
        return usersResponseDto;
    }
}
