package com.jojoldu.book.springboot.web.Dto;

import com.jojoldu.book.springboot.domain.MovieInfo.MovieInfo;
import com.jojoldu.book.springboot.domain.MovieReview.MovieReview;
import lombok.Getter;

@Getter
public class ReviewListResponseDto {
    private int id;
    private String userId;
    private MovieInfo movieInfo;
    private String title;
    private String content;
    private int score;
    private int viewCount;
    private String regDate;
    private String modifyDate;
    private String openYn;
    private String deleteYn;

    public ReviewListResponseDto(MovieReview entity){
        this.id = entity.getId();
        this.userId = entity.getUserId();
        this.movieInfo = entity.getMovieInfo();
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
