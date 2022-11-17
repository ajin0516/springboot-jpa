package com.example.springbootjap.Service;

import com.example.springbootjap.Repository.UsersRepository;
import com.example.springbootjap.domain.Users;
import com.example.springbootjap.domain.dto.UsersRequestDto;
import com.example.springbootjap.domain.dto.UsersResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UsersResponseDto getUser(Long id) {
        Optional<Users> optionalUsers = usersRepository.findById(id);
        if (optionalUsers.isEmpty()) {
            return new UsersResponseDto(id, "", "해당 id의 유저가 없습니다.");
        } else {
            Users users = optionalUsers.get();
            return new UsersResponseDto(users.getId(), users.getUsername(), "");
        }
    }

    public UsersResponseDto addUser(UsersRequestDto usersRequestDto) {
        // 요청 -> 디비 -> 응답
        // requestDto -> entity
        Users usersEntity = usersRequestDto.toEntity();
        // DB에 있는 데이터 담아주기
        List<Users> users = usersRepository.findAll();
        // DB에 담긴 데이터와 usersEntity에 담긴 데이터 비교하기
        for (Users user : users) {
            if (usersEntity.getUsername().equals(user.getUsername())) {
                // 응답
                return new UsersResponseDto(usersEntity.getId(), usersEntity.getUsername(), "해당 user는 중복입니다");
            }
        }
        // 같지 않다면 usersRepository 저장 후 반환
        // 2 디비 저장
        Users saveUser = usersRepository.save(usersEntity);
        // 3 응답
        return new UsersResponseDto(saveUser.getId(), saveUser.getUsername(), "회원 등록 성공");
    }
}
