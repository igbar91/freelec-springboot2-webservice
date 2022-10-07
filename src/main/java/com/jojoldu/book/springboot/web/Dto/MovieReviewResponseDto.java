package com.jojoldu.book.springboot.web.Dto;

import com.jojoldu.book.springboot.domain.MovieInfo.MovieInfo;
import com.jojoldu.book.springboot.domain.MovieReview.MovieReview;
import lombok.Getter;

@Getter
public class MovieReviewResponseDto {
    private long id;
    private long userId;
    private long movieId;
    private String title;
    private String content;
    private int score;
    private int viewCount;
    private String regDate;
    private String modifyDate;
    private Character openYn;
    private Character deleteYn;

    public MovieReviewResponseDto(MovieReview entity){
        this.id = entity.getId();
        this.userId = entity.getUserId();
        this.movieId = entity.getMovieId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.score = entity.getScore();
        this.viewCount = entity.getViewCount();
        this.regDate = entity.getRegDate();
        this.modifyDate = entity.getModifyDate();
        this.openYn = entity.getOpenYn();
        this.deleteYn = entity.getDeleteYn();
    }
}
