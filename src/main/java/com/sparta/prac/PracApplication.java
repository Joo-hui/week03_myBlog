package com.sparta.prac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //JPA사용할때 필수적으로 넣어줘야함 !!!!!!!!!!!이걸 넣어줘야 수정시간이 바꼈을때 자동으로 업데이트를 해준다.
@SpringBootApplication
public class PracApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracApplication.class, args);
	}

}
