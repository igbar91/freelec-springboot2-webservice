package com.jojoldu.book.springboot.domain.GenreInfo;

import org.springframework.data.jpa.repository.JpaRepository;

//Database를 접근하게 해 줄 Jpa Repository
//단순히 인터페이스를 생성 후 , JpaRepository<Entity클래스, PK타입>를 상속하면 기본적인 CRUD메소드가 자동으로 생성.
public interface GenreInfoRepository  extends JpaRepository<GenreInfo, Long> {
}
