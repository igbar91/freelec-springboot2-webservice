package com.jojoldu.book.springboot.domain.MovieReview;


import com.jojoldu.book.springboot.domain.CountryInfo.CountryInfo;
import com.jojoldu.book.springboot.domain.GenreInfo.GenreInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor //롬복 어노테이션
@Entity //jpa의 어노테이션
public class MovieReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long movieId;

    @Column(length = 200, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(length = 5, nullable = false)
    private int score;

    @Column(nullable = true)
    private int viewCount;

    @Column(nullable = false)
    private String regDate;

    @Column(nullable = true)
    private String modifyDate;

    @Column(nullable = false)
    private Character openYn;

    @Column(nullable = false)
    private Character deleteYn;

    @Builder
    public MovieReview(long id, long userId, long movieId, String title, String content, int score, int viewCount, String regDate, String modifyDate, Character openYn, Character deleteYn){
        this.id = id;
        this.userId = userId;
        this.movieId = movieId;
        this.title = title;
        this.content = content;
        this.score = score;
        this.viewCount = viewCount;
        this.regDate = regDate;
        this.modifyDate = modifyDate;
        this.openYn = openYn;
        this.deleteYn = deleteYn;

    }
}
