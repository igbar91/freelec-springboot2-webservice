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
public class ReviewSaveRequestDto {

    private MovieInfo movieInfo;
    private String title;
    private String content;
    private int score;
    private String openYn;
    private String deleteYn;
    private String regDate;
    private int movieId;
    private String userId;

    @Builder
    public ReviewSaveRequestDto(MovieInfo movieInfo, int movieId, String title, String content, int score, String openYn, String deleteYn, String regDate, String userId){

        this.movieInfo = movieInfo;
        this.movieId = movieId;
        this.title = title;
        this.content = content;
        this.score = score;
        this.openYn = openYn;
        this.deleteYn = deleteYn;
        this.regDate = regDate;
        this.userId = userId;
    }
    public MovieReview toEntity(){
        return MovieReview.builder()
                .movieInfo(movieInfo)
                .title(title)
                .content(content)
                .score(score)
                .openYn(openYn)
                .deleteYn(deleteYn)
                .regDate(regDate)
                .userId(userId)
                .build();
    }
}
