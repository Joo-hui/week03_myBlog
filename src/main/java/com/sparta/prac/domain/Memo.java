package com.sparta.prac.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Memo extends Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String pwd;

//    public Memo(String username, String contents, String title, String pwd) {
//        this.username = username;
//        this.contents = contents;
//        this.title = title;
//        this.pwd = pwd;
//    }

    public Memo(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
        this.pwd = requestDto.getPwd();
    }
    public void update(MemoRequestDto requestDto) { //반환타입 아무것도 없어도 되니 void. 값을 전달 받아야 하는데 service에서 전달 받기로 한게 requestDto 임
//        this.username = requestDto.getUsername(); //실제 지금 내용을 바꿔줘야 하니
        this.contents = requestDto.getContents(); //우리가 변경해야 하는 값을 실어나른 dto에 있는 값이 findById로 찾은 이 Memo 안에 들어간다.
//        this.title = requestDto.getTitle();
//        this.pwd = requestDto.getPwd();
    }
}