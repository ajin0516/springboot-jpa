package com.example.springbootjap.Service;

import com.example.springbootjap.Repository.UsersRepository;
import com.example.springbootjap.domain.Users;
import com.example.springbootjap.domain.dto.UsersRequestDto;
import com.example.springbootjap.domain.dto.UsersResponseDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UsersResponseDto getUser(Long id) {
        Optional<Users> optionalUsers = usersRepository.findById(id);
        if(optionalUsers.isEmpty()){
            return new UsersResponseDto(id,"","해당 id의 유저 없어");
        } else if (optionalUsers.isPresent()) {
            return new UsersResponseDto(id,"","해당 id는 중복이야");
        } else {
            Users users = optionalUsers.get();
            return new UsersResponseDto(users.getId(), users.getUsername(), "");
        }
    }

//    public UsersResponseDto add(UsersRequestDto usersRequestDto) {
//        // 요청 -> 디비 -> 응답
//        // 1 요청
//        Users usersEntity = usersRequestDto.toEntity();
//        // 2 디비
//        usersRepository.save(usersEntity);
//        // 3 응답
//        UsersResponseDto responseDto = Users.of(usersEntity);
//
//        return responseDto;
//    }

}
