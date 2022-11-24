package com.jojoldu.book.springboot.web;


import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.domain.MovieInfo.MovieInfo;
import com.jojoldu.book.springboot.domain.MovieReview.MovieReview;
import com.jojoldu.book.springboot.service.movieInfo.MovieInfoService;
import com.jojoldu.book.springboot.web.Dto.MovieInfoListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class MovieController {

    private final MovieInfoService movieInfoService;
    private final HttpSession httpSession;

    @PersistenceContext
    private EntityManager em; //영속성관리

    @GetMapping("/movie")
    public String movie(Model model, @LoginUser SessionUser user){
        model.addAttribute("movieInfo", movieInfoService.findAllDesc());

        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        return "movie-list";
    }

    @GetMapping("/movie/view/{id}")
    public String movieView(Model model, @PathVariable int id, @LoginUser SessionUser user){

        if(user != null){
            model.addAttribute("userName", user.getName());
        }

        MovieInfoListResponseDto dto = movieInfoService.findById(id);

        MovieInfo info = em.find(MovieInfo.class, id);//review
        int reviewSize = info.getMovieReviews().size();

        if(reviewSize>0) {
            List<MovieReview> reviews = info.getMovieReviews();
            model.addAttribute("review", reviews.get(0));
        }
        model.addAttribute("view", dto);
        model.addAttribute("reviewSize", reviewSize);

        return "movie-view";
    }

}
