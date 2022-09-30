package com.jojoldu.book.springboot.web.Dto;


import com.jojoldu.book.springboot.domain.CountryInfo.CountryInfo;
import com.jojoldu.book.springboot.domain.GenreInfo.GenreInfo;
import com.jojoldu.book.springboot.domain.MovieInfo.MovieInfo;
import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MovieInfoListResponseDto {
    private Long id;
    private CountryInfo countryInfo;
    private String profileImage;
    private String name;
    private String screenDate;
    private int screenTime;
    private String ageLimit;
    private String director;
    private String caster;
    private String summary;
    private GenreInfo genreInfo;

    public MovieInfoListResponseDto(MovieInfo entity){
        this.id = entity.getId();
        this.countryInfo = entity.getCountryInfo();
        this.profileImage = entity.getProfileImage();
        this.name = entity.getName();
        this.screenDate = entity.getScreenDate();
        this.screenTime = entity.getScreenTime();
        this.ageLimit = entity.getAgeLimit();
        this.director = entity.getDirector();
        this.caster = entity.getCaster();
        this.summary = entity.getSummary();
        this.genreInfo = entity.getGenreInfo();
    }
}
