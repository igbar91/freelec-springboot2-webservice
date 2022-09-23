package com.jojoldu.book.springboot.domain.movieInfo;

import com.jojoldu.book.springboot.Application;
import com.jojoldu.book.springboot.domain.MovieInfo.MovieInfo;
import com.jojoldu.book.springboot.domain.MovieInfo.MovieInfoRepository;
import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class movieInfoTest {

    @Autowired
    MovieInfoRepository movieInfoRepository;

    @After
    public void cleanup() {
        movieInfoRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        int genre_id = 4;
        int country_id = 5;
        String profile_image = "/asset/image";
        String name = "메타버스";
        int screen_time = 111;
        String age_limit = "전체관람가";
        String director = "yiyeon";
        String caster = "전소연,김혜수,정상우";
        String summary = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";


        movieInfoRepository.save(MovieInfo.builder()
                .genre_id(genre_id)
                .country_id(country_id)
                .profile_image(profile_image)
                .name(name)
                .screen_time(screen_time)
                .age_limit(age_limit)
                .director(director)
                .caster(caster)
                .summary(summary)
                .build());   //insert, update쿼리

        //when
        List<MovieInfo> movieInfoList = movieInfoRepository.findAll(); //조회쿼리

        //then
        MovieInfo movieInfo = movieInfoList.get(0);

        assertThat(movieInfo.getGenre_id(), is(equalTo(genre_id)));
        assertThat(movieInfo.getCountry_id(), is(equalTo(country_id)));
        assertThat(movieInfo.getProfile_image(), is(equalTo(profile_image)));
        assertThat(movieInfo.getName(), is(equalTo(name)));
        assertThat(movieInfo.getScreen_time(), is(equalTo(screen_time)));
        assertThat(movieInfo.getAge_limit(), is(equalTo(age_limit)));
        assertThat(movieInfo.getDirector(), is(equalTo(director)));
        assertThat(movieInfo.getCaster(), is(equalTo(caster)));
        assertThat(movieInfo.getSummary(), is(equalTo(summary)));
    }

}