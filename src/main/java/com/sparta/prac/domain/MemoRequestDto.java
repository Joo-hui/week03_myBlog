package com.sparta.prac.domain;

import lombok.Getter;

@Getter // private을 그냥 가져오게 되면 문제가 생기기 때문에 Getter 어노테이션을 붙여준다
public class MemoRequestDto {   //필요한 정보를 물고 다니는애고 수정 요청이 오면 기본적으로 알아야 할 내용이 있어야 한다.
    private String username;
    private String contents;
    private String title;
    private String pwd;
    // 나중에 받을때 스프링이 알아서 setter를 설정해주기 때문에 따로 setter를 설정할 필요는 없으며 getter만 있으면 된다.
}

