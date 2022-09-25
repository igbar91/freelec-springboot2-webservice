package com.jojoldu.book.springboot.web.Dto;


import com.jojoldu.book.springboot.domain.MovieInfo.MovieInfo;
import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MovieInfoListResponseDto {
    private Long id;
    private int genre_id;
    private int country_id;
    private String profile_image;
    private String name;
    private String screenDate;
    private int screen_time;
    private String age_limit;
    private String director;
    private String caster;
    private String summary;


    public MovieInfoListResponseDto(MovieInfo entity){
        this.id = entity.getId();
        this.genre_id = entity.getGenre_id();
        this.country_id = entity.getCountry_id();
        this.profile_image = entity.getProfile_image();
        this.name = entity.getName();
        this.screenDate = entity.getScreenDate();
        this.screen_time = entity.getScreen_time();
        this.age_limit = entity.getAge_limit();
        this.director = entity.getDirector();
        this.caster = entity.getCaster();
        this.summary = entity.getSummary();
    }
}
