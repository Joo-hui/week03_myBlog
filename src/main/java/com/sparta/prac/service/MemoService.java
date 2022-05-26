package com.sparta.prac.service;


import com.sparta.prac.domain.Memo;
import com.sparta.prac.domain.MemoRepository;
import com.sparta.prac.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

//*업데이트에 필수 @RequiredArgsConstructor
@RequiredArgsConstructor    //final을 쓰기 위해 조치를 한다. final로 선언된 애 있으면 그거 생성할때 그거 모조건 넣어줄게 라고 스프링에게 전달
@Service //스프링에게 얘가 service라는걸 알려줘야 함
public class MemoService {

    private final MemoRepository memoRepository; //메모에 대해서 뭔가를 찾으려면 Repository가 있어야 해서 Service에 멤버 변수로 선언해준다.

    @Transactional  //업데이트할때 이게 DB에 진짜 반영이 되어야해 라고 한번 더 말해주는 어노테이션 *업데이트에 필수
    public Long update(Long id, MemoRequestDto requestDto) { //변경시킬 아이디, 그리고 변경시킬 내용(데이터 물고 다니는애)
        Memo memo = memoRepository.findById(id).orElseThrow( //id를 기준으로 필요한 정보를 먼저 찾고 없으면 어쩔거야
                () -> new NullPointerException("아이디가 존재하지 않습니다.") // 그럼 뭔가 새로운 오류를 발생시켜라. 알려줘
        ); // 그럼 그 결과물은 Memo memo가 반환된다. memoRepository는 메모를 찾는 애니까
        memo.update(requestDto); //memo 클래스 바탕으로 업데이트를 해준다. requestDto를 가지고 생각을 해야한다.
        return id; //그리고 반환해야 하는애는 어떤애가 업데이트가 됐는지 id를 돌려준다.
    }
}
