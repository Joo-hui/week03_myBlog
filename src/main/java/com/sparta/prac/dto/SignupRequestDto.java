package com.sparta.prac.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {
    private String username;
    private String password;
    private String email;
    private boolean admin = false;  //! admin이 true면 관리자 admin이 false면 일반 회원 으로 판단
    private String adminToken = ""; //!
}