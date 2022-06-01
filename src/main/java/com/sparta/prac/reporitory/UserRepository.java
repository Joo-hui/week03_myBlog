package com.sparta.prac.reporitory;


import com.sparta.prac.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username); //findByUsername은 user에 대한 테이블에서 String username를 가지고 username을 뒤져보겠다. 그리고 그 결과를 Optional<User> 로 넘겨주겠다.
}