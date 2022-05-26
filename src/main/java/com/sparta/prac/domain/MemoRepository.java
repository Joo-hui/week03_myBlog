package com.sparta.prac.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    //JpaRepository 갖다 쓸거다. 대상은 메모라는 클래스로 아이디는 long이라는 애를 가져다 쓸거야
    List<Memo> findAllByOrderByModifiedAtDesc();
    //다 찾아주고 Oderby(순서) 순서대로 정렬을 해줘 ModifiedAt(수정된 날짜) 기준으로 desc 최신순으로(내림차순)
    //ModifiedAt은 어디서 나온거냐면 Memo 클래스는 Timestamped 클래스를 상속하고 있고
    //Timestamped 클래스는 두가지 필드를 가지고 있어 그중에 있는 Memo 클래스가 ModifiedAt 을 가질 수 있는거고 그걸 여기로 따온거다.
}
