package com.jojoldu.book.springboot.web.Dto;

import com.jojoldu.book.springboot.domain.MovieInfo.MovieInfo;
import com.jojoldu.book.springboot.domain.MovieReview.MovieReview;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ReviewUpdateRequestDto {

    private String title;
    private String content;
    private int score;
    private String openYn;
    private String modifyDate;
    private MovieInfo movieInfo;
    private int movieId;

    @Builder
    public ReviewUpdateRequestDto(String title, String content, int score, String openYn, String deleteYn, String modifyDate, MovieInfo movieInfo, int movieId){
        this.title = title;
        this.content = content;
        this.score = score;
        this.openYn = openYn;
        this.modifyDate = modifyDate;
        this.movieInfo = movieInfo;
        this.movieId = movieId;

    }
    public MovieReview toEntity(){
        return MovieReview.builder()
                .title(title)
                .content(content)
                .score(score)
                .openYn(openYn)
                .modifyDate(modifyDate)
                .movieInfo(movieInfo)
                .build();
    }
}
