package com.jojoldu.book.springboot.web;


import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.service.movieInfo.MovieInfoService;
import com.jojoldu.book.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class MovieController {

    private final MovieInfoService movieInfoService;
    private final HttpSession httpSession;

    @GetMapping("/movie")
    public String movie(Model model, @LoginUser SessionUser user){
        model.addAttribute("movieInfo", movieInfoService.findAllDesc());

        //userName을 Model 에 저장
        //SessionUser user = (SessionUser)httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        return "movie";
    }
}
