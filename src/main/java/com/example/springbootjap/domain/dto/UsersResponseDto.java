package com.example.springbootjap.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersResponseDto {
    private Long id;
    private String username;
    private String message;
}
