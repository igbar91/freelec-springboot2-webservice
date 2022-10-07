package com.jojoldu.book.springboot.web;


import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.service.movieInfo.MovieInfoService;
import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.web.Dto.MovieInfoListResponseDto;
import com.jojoldu.book.springboot.web.Dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.Map;

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

    @GetMapping("/movie/view/{id}")
    public String movieView(Model model, @PathVariable Long id, @LoginUser SessionUser user){
        MovieInfoListResponseDto dto = movieInfoService.findById(id);
        model.addAttribute("view", dto);
        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        return "movie-view";
    }
}
