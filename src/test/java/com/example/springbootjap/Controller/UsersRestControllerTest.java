package com.example.springbootjap.Controller;

import com.example.springbootjap.Service.UsersService;
import com.example.springbootjap.domain.dto.UsersRequestDto;
import com.example.springbootjap.domain.dto.UsersResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsersRestController.class)
class UsersRestControllerTest {

    @MockBean
   UsersService usersService;

    @Autowired
    MockMvc mockMvc;


    @Test
    @DisplayName("입력한 id로 조회가 잘 되는지")
    void findById() throws Exception {

        given(usersService.getUser(20l)).willReturn(new UsersResponseDto(20l, "ajinnnn", "회원 등록 성공"));
        mockMvc.perform(get("/api/v1/users/20"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.id").value(20l))
                .andExpect(jsonPath("$.message").value("회원 등록 성공"))
                .andDo(print());
    }

    @Test
    @DisplayName("입력한 id로 조회 실패 했을 떄 message 잘 나오는지")
    void findByIdFail() throws Exception {
        given(usersService.getUser(2l)).willReturn(new UsersResponseDto(null, "", "해당 id의 유저가 없습니다"));

        mockMvc.perform(get("/api/v1/users/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isEmpty())
                .andExpect(jsonPath("$.message").value("해당 id의 유저가 없습니다"))
                .andDo(print());
    }

}