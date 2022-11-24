package com.jojoldu.book.springboot.domain.MovieReview;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.jojoldu.book.springboot.domain.CountryInfo.CountryInfo;
import com.jojoldu.book.springboot.domain.GenreInfo.GenreInfo;
import com.jojoldu.book.springboot.domain.MovieInfo.MovieInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor //롬복 어노테이션
@Entity //jpa의 어노테이션
public class MovieReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String userId;

    //양방향매핑 여러게시글은 하나의 post에 전속된다.
    //외래키가 있는 게시글이 주인, mapped by된 쪽은 조회만
    @ManyToOne
    @JoinColumn(name = "movieId")
    MovieInfo movieInfo;

    @Column(length = 200, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(length = 5, nullable = false)
    private int score;

    @Column(columnDefinition = "integer default 0", nullable = false)
    private int viewCount;

    //save > regDate, update > modifyDate
    @Column(nullable = true)
    private String regDate;

    @Column(nullable = true)
    private String modifyDate;

    @Column(nullable = false, columnDefinition ="char")
    private String openYn;

    @Column(nullable = false, columnDefinition ="char")
    private String deleteYn;

    @Builder
    public MovieReview(int id, String userId, MovieInfo movieInfo, String title, String content, int score, int viewCount, String regDate, String modifyDate, String openYn, String deleteYn){
        this.id = id;
        this.userId = userId;
        this.movieInfo = movieInfo;
        this.title = title;
        this.content = content;
        this.score = score;
        this.viewCount = viewCount;
        this.regDate = regDate;
        this.modifyDate = modifyDate;
        this.openYn = openYn;
        this.deleteYn = deleteYn;

    }

    public void update(String title, String content, int score, String openYn, String modifyDate, MovieInfo movieInfo){
        this.title = title;
        this.content = content;
        this.score = score;
        this.openYn = openYn;
        this.modifyDate = modifyDate;
        this.movieInfo = movieInfo;
    }
}
