package com.jojoldu.book.springboot.web;


import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.service.movieReview.MovieReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class ReviewController {

    private final MovieReviewService movieReviewService;
    private final HttpSession httpSession;

    @GetMapping("/review")
    public String review(Model model, @LoginUser SessionUser user){

        model.addAttribute("list", movieReviewService.findAllDesc());
        long totalCount = movieReviewService.getAllCount();
        model.addAttribute("totalCount", totalCount);

        //userName을 Model 에 저장
        //SessionUser user = (SessionUser)httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        return "review-list";
    }

}
