package com.example.springbootjap.Service;

import com.example.springbootjap.Repository.UsersRepository;
import com.example.springbootjap.domain.Users;
import com.example.springbootjap.domain.dto.UsersRequestDto;
import com.example.springbootjap.domain.dto.UsersResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class UsersServiceTest {

    private UsersRepository usersRepository = Mockito.mock(UsersRepository.class);

    private UsersService usersService;

    @BeforeEach
    void beforeEach() {
        usersService = new UsersService(usersRepository); // 수동 Di
    }

    @Test
    @DisplayName("회원 등록 성공 메세지가 잘 나오는지")
    void addTest() {
        Mockito.when(usersRepository.save(any()))
                .thenReturn(new Users(1l,"ajin","12313"));

        UsersResponseDto usersResponseDto = usersService.addUser(new UsersRequestDto("ajin", "12313"));
        assertEquals("ajin",usersResponseDto.getUsername());
        assertEquals("회원 등록 성공",usersResponseDto.getMessage());
    }

}