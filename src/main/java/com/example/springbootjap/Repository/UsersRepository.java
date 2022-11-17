package com.example.springbootjap.Repository;

import com.example.springbootjap.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {
}
