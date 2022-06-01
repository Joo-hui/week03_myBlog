package com.sparta.prac.controller;


import com.sparta.prac.domain.Memo;
import com.sparta.prac.reporitory.MemoRepository;
import com.sparta.prac.dto.MemoRequestDto;
import com.sparta.prac.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoRepository memoRepository; //생성, 조회, 삭제하기 위해 필요. 멤버이고 필수적인 애들이라 private final 붙여줌
    private final MemoService memoService; //업데이트하기 위해 필요

    @PostMapping("/api/memos") //api/memos의 요청이 POST의 방식으로 들어왔을때 아래 코드를 실행해라
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) { //createMemo는 정해진거 없고 내가 알아서 정한다. 생성하려면 생성할 메모의 데이터를 받아야한다.데이터 물고 다니는애를 받아야 함
         //@RequestBody 데이터에 정확하게 넣어주기 위해 꼭 필요함
        Memo memo = new Memo(requestDto); //메모 붙여 넣기 위해 Memo memo = new Memo를 생성하고 Memo클래스에서 생성자에서 requestDto 받아서 바로 정보 넣어서 생성해주는 생성자 활용 / requestDto를 파라미터로 준다
        //그럼 requestDto 에 있는 데이터가 알아서 메모로 들어가서 다 채워놓는다.
        return memoRepository.save(memo); //그럼 우린 저장만 하면 된다. 내가 방금 생성한 메모를. Repository = 저장하는 애 / save는 알아서 리턴해준다.
    }
    @GetMapping("/api/memos") //Get방식으로 이 요청이 왔을때
    public List<Memo> getMemo() { //반환방식이 ListMemo
        return memoRepository.findAllByOrderByModifiedAtDesc(); //memoRepository 에서 다 찾아서 ModifiedAt 기준으로 내림차순 정렬해줘
    }

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) { //주소와 내용을 받아와야한다.
        memoService.update(id, requestDto); //service를 통해 업데이트를 했으며 업데이트할꺼는 어떤애고 데이터는 이거다하고 id랑 데이터 물고 다니는애를 준다.
        return id;

    }


    @DeleteMapping("/api/memos/{id}") //어떤애를 삭제해야 하는지 요청을 받는다.
    public Long deleteMemo(@PathVariable Long id) { // id가 어디있는지 모르기 때문에 경로에 있는 변수 (id)를 받기 위해 @PathVariable을 넣어준다.
        memoRepository.deleteById(id); //repository에 deleteById 라는 애를 사용해서 id를 넣어준다.
        return id;
    }
    @GetMapping("/api/memos/{id}")
    public String pwdMemo(@PathVariable Long id) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new NullPointerException("아이디가 존재하지않습니다.")
        );
        return memo.getPwd();
    }
}