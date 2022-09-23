package com.jojoldu.book.springboot.domain.MovieInfo;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@NoArgsConstructor //롬복 어노테이션
@Entity //jpa의 어노테이션
public class MovieInfo {
    //entity class라고도 함.
    //JPA를 사용하면 DB 데이터에 작업할 경우 실제 쿼리를 날리기보다는 이 Entity 클래스의 ㅅ정을 통해 작어함.
    //기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭 ex movie_info > MovieInfo.class

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 11, nullable = false)
    private int genre_id;

    @Column(length = 11, nullable = false)
    private int country_id;

    @Column(length = 200, nullable = true)
    private String profile_image;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(length = 200, nullable = false)
    private int screen_time;

    @Column(nullable = false)
    private String screen_date;

    @Column(length = 50, nullable = false)
    private String age_limit;

    @Column(length = 50, nullable = false)
    private String director;

    @Column(length = 1000, nullable = false)
    private String caster;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String summary;

    @Builder
    public MovieInfo(int genre_id,int country_id, String profile_image, String name, String screen_date, int screen_time, String age_limit, String director, String caster, String summary){
        this.genre_id = genre_id;
        this.country_id = country_id;
        this.profile_image = profile_image;
        this.name = name;
        this.screen_date = screen_date;
        this.screen_time = screen_time;
        this.age_limit = age_limit;
        this.director = director;
        this.caster = caster;
        this.summary = summary;
    }

}
