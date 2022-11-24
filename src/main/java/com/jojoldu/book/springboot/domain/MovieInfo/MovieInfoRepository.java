package com.jojoldu.book.springboot.domain.MovieInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Entity;
import java.util.List;

//MovieInfo 클래스로 Database를 접근하게 해 줄 Jpa Repository
//단순히 인터페이스를 생성 후 , JpaRepository<Entity클래스, PK타입>를 상속하면 기본적인 CRUD메소드가 자동으로 생성.
public interface MovieInfoRepository extends JpaRepository<MovieInfo, Integer> {

    @Query("SELECT a From MovieInfo a ORDER BY a.screenDate DESC, a.name")
    List<MovieInfo> findAllDesc();

    List<MovieInfo> findTop4ByOrderByScreenDateDesc();

    @Query("SELECT COUNT(*) From MovieInfo a")
    int getAllCount();

}
