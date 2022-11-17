package com.example.springbootjap.Controller;

import com.example.springbootjap.Repository.UsersRepository;
import com.example.springbootjap.Service.UsersService;
import com.example.springbootjap.domain.Users;
import com.example.springbootjap.domain.dto.UsersRequestDto;
import com.example.springbootjap.domain.dto.UsersResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UsersRestController {

    private final UsersService usersService;

    public UsersRestController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersResponseDto> getUsers(@PathVariable Long id) {
        UsersResponseDto usersById = usersService.getUser(id);
        return ResponseEntity.ok().body(usersById);
    }

    @PostMapping
    public ResponseEntity<UsersResponseDto> postUsersDto(@RequestBody UsersRequestDto usersRequestDto) {
        UsersResponseDto usersResponseDto = usersService.addUser(usersRequestDto);
        return ResponseEntity.ok().body(usersResponseDto);
    }
}
