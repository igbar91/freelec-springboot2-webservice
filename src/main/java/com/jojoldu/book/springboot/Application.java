package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


//@EnableJpaAuditing과 @Springbootapplication이 함께 있다보니 @WebMvcTest도 스캔하게 되는데 이 경우 @WebMvcTest가 없으면 에러가남
//그래서 Application.java에서 EnableJpaAuditing을 주석시키고 JpaConfig파일로 분리시킴.
//@EnableJpaAuditing // JPA Auditing 삭제됨.
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }
}
