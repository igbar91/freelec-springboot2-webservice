package com.jojoldu.book.springboot.web;


import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.domain.MovieInfo.MovieInfo;
import com.jojoldu.book.springboot.domain.MovieInfo.MovieInfoRepository;
import com.jojoldu.book.springboot.domain.MovieReview.MovieReview;
import com.jojoldu.book.springboot.domain.MovieReview.MovieReviewRepository;
import com.jojoldu.book.springboot.domain.user.UserRepository;
import com.jojoldu.book.springboot.service.movieInfo.MovieInfoService;
import com.jojoldu.book.springboot.service.movieReview.MovieReviewService;
import com.jojoldu.book.springboot.web.Dto.ReviewListResponseDto;
import com.jojoldu.book.springboot.web.Dto.ReviewSaveRequestDto;
import com.jojoldu.book.springboot.web.Dto.ReviewUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Map;

@RequiredArgsConstructor
@Controller
public class ReviewApiController {

    private final MovieReviewService movieReviewService;
    private final MovieInfoService movieInfoService;
    private final MovieReviewRepository movieReviewRepository;
    private final HttpSession httpSession;

    @GetMapping(value = "/review")
    public String review(Model model, @LoginUser SessionUser user,@PageableDefault(page = 0, size = 10, sort = "id" , direction = Sort.Direction.DESC
    ) Pageable pageable) {
        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        int reviewCount = movieReviewService.getAllCountByOpenYn();
        int postCount = movieInfoService.getAllCount();

        Page<MovieReview> list = movieReviewRepository.findAllByOpenYn(pageable);
        int nowPage = list.getPageable().getPageNumber()+1;
        int startPage = Math.max(nowPage -4, 1);
        int endPage = Math.min(nowPage + 5, list.getTotalPages());

        model.addAttribute("reviewCount", reviewCount);
        model.addAttribute("postCount", postCount);
        model.addAttribute("list", list);

        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);


        return "review-list";
    }

    @GetMapping("/review/read/{id}")
    public String read(Model model, @PathVariable int id, @LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        movieReviewService.updateView(id); // views ++ >쿠키 세션 방지 추가 필요
        ReviewListResponseDto dto = movieReviewService.findById(id);
        model.addAttribute("view", dto);
        model.addAttribute("movieList", movieInfoService.findAllDesc());
        return "review-read";
    }

    @GetMapping("/review/form")
    public String registerForm(Model model, @LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        model.addAttribute("movieList", movieInfoService.findAllDesc());
        return "review-save";
    }

    @ResponseBody
    @PostMapping("/api/v1/review")
    public int register(@RequestBody ReviewSaveRequestDto requestDto, @LoginUser SessionUser user){
        requestDto.setUserId(user.getName());
        return movieReviewService.save(requestDto);
    }

    @GetMapping(value = "/myReviews")
    public String myReviews(Model model, @LoginUser SessionUser user,@PageableDefault(page = 0, size = 10, sort = "id" , direction = Sort.Direction.DESC
    ) Pageable pageable) {
        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        int reviewCount = movieReviewRepository.getAllCountByUserId(user.getName());
        int postCount = movieInfoService.getAllCount();

        Page<MovieReview> list = movieReviewRepository.findAllByUserId(pageable, user.getName());

        int nowPage = list.getPageable().getPageNumber()+1;
        int startPage = Math.max(nowPage -4, 1);
        int endPage = Math.min(nowPage + 5, list.getTotalPages());

        model.addAttribute("reviewCount", reviewCount);
        model.addAttribute("postCount", postCount);
        model.addAttribute("list", list);

        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "myReview-list";
    }

    @GetMapping("/review/update/{id}")
    public String updateForm(Model model, @PathVariable int id, @LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        ReviewListResponseDto dto = movieReviewService.findById(id);
        model.addAttribute("view", dto);
        model.addAttribute("movieList", movieInfoService.findAllDesc());
        return "review-update";
    }

    @ResponseBody
    @PutMapping("/api/v1/review/{id}")
    public int update(@PathVariable int id, @RequestBody ReviewUpdateRequestDto requestDto){
        return movieReviewService.update(id, requestDto);
    }

    @ResponseBody
    @DeleteMapping("/api/v1/review/{id}")
    public int delete(@PathVariable int id){
        movieReviewService.delete(id);
        return id;
    }


}
