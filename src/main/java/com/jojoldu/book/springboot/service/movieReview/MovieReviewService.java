package com.jojoldu.book.springboot.service.movieReview;


import com.jojoldu.book.springboot.domain.MovieReview.MovieReviewRepository;
import com.jojoldu.book.springboot.web.Dto.MovieInfoListResponseDto;
import com.jojoldu.book.springboot.web.Dto.MovieReviewResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MovieReviewService {

    private final MovieReviewRepository movieReviewRepository;

    @Transactional(readOnly = true)
    public List<MovieReviewResponseDto> findAllDesc(){
        return movieReviewRepository.findAllDesc().stream()
                .map(MovieReviewResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public long getAllCount(){
        return movieReviewRepository.getAllCount();
    }

}
