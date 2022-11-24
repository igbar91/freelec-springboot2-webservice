package com.jojoldu.book.springboot.web;


import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.domain.MovieInfo.MovieInfoRepository;
import com.jojoldu.book.springboot.domain.MovieReview.MovieReviewRepository;
import com.jojoldu.book.springboot.service.movieInfo.MovieInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final MovieInfoService movieInfoService;
    private final HttpSession httpSession;
    private final MovieInfoRepository movieInfoRepository;
    private final MovieReviewRepository movieReviewRepository;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){

        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        model.addAttribute("movieInfo", movieInfoRepository.findTop4ByOrderByScreenDateDesc());
        model.addAttribute("reviewInfo", movieReviewRepository.findTop4ByOrderByRegDateDesc());
        return "index";
    }

}
