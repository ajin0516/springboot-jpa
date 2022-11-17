package com.example.springbootjap.domain.dto;


import com.example.springbootjap.domain.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UsersRequestDto {

//    private Long id;
    private String username;
    private String password;

    /*
    requestDto -> entity
     */
    public Users toEntity() {
        return Users.builder()
                .username(this.username)
                .password(this.password)
                .build();
    }
}

