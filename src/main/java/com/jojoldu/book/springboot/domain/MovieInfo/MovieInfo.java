package com.jojoldu.book.springboot.domain.MovieInfo;


import com.jojoldu.book.springboot.domain.CountryInfo.CountryInfo;
import com.jojoldu.book.springboot.domain.GenreInfo.GenreInfo;
import com.jojoldu.book.springboot.domain.MovieReview.MovieReview;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter // testCode
@Getter
@NoArgsConstructor //롬복 어노테이션
@Entity //jpa의 어노테이션
public class MovieInfo {
    //entity class라고도 함.
    //JPA를 사용하면 DB 데이터에 작업할 경우 실제 쿼리를 날리기보다는 이 Entity 클래스의 ㅅ정을 통해 작어함.
    //기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭 ex movie_info > MovieInfo.class

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "countryId")
    CountryInfo countryInfo;

    @Column(length = 200, nullable = true)
    private String profileImage;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(length = 200, nullable = false)
    private int screenTime;

    @Column(nullable = false)
    private String screenDate;

    @Column(length = 50, nullable = false)
    private String ageLimit;

    @Column(length = 50, nullable = false)
    private String director;

    @Column(length = 1000, nullable = false)
    private String caster;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String summary;

    @OneToOne
    @JoinColumn(name = "genreId") //MovieInfo에 적용할 column name : genre_id, 조인할 컬럼명은 특정하지 않으면 자동으로 pk(genreInfo)랑 연결해준다.
    GenreInfo genreInfo;//@Column(length = 11, nullable = false)

    //양방향매핑 하나의 post는 여러 리뷰게시글을 가진다.
    @OneToMany(mappedBy = "movieInfo")
    private List<MovieReview> movieReviews = new ArrayList<>();


    @Builder
    public MovieInfo(CountryInfo countryInfo, String profileImage, String name, String screenDate, int screenTime, String ageLimit, String director, String caster, String summary, GenreInfo genreInfo){
        this.countryInfo = countryInfo;
        this.profileImage = profileImage;
        this.name = name;
        this.screenDate = screenDate;
        this.screenTime = screenTime;
        this.ageLimit = ageLimit;
        this.director = director;
        this.caster = caster;
        this.summary = summary;
        this.genreInfo = genreInfo;

    }


}
