package com.jojoldu.book.springboot.service.movieReview;


import com.jojoldu.book.springboot.domain.MovieInfo.MovieInfo;
import com.jojoldu.book.springboot.domain.MovieInfo.MovieInfoRepository;
import com.jojoldu.book.springboot.domain.MovieReview.MovieReview;
import com.jojoldu.book.springboot.domain.MovieReview.MovieReviewRepository;
import com.jojoldu.book.springboot.web.Dto.ReviewListResponseDto;
import com.jojoldu.book.springboot.web.Dto.ReviewSaveRequestDto;
import com.jojoldu.book.springboot.web.Dto.ReviewUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MovieReviewService {

    private final MovieReviewRepository movieReviewRepository;
    private final MovieInfoRepository movieInfoRepository;


/*    @Transactional(readOnly = true)
    public List<ReviewListResponseDto> findAllDesc(Pageable pageable){
        return movieReviewRepository.findAllDesc(pageable).stream()
                .map(ReviewListResponseDto::new)
                .collect(Collectors.toList());
    }*/

    @Transactional(readOnly = true)
    public int getAllCountByOpenYn(){
        return movieReviewRepository.getAllCountByOpenYn();
    }

    @Transactional
    public int save(ReviewSaveRequestDto requestDto){

        MovieInfo movieInfo = movieInfoRepository.findById(requestDto.getMovieId()).orElseThrow(() -> new IllegalArgumentException("해당 영화이름이 존재하지 않습니다."));
        requestDto.setMovieInfo(movieInfo);
        return movieReviewRepository.save(requestDto.toEntity()).getId();
    }
    public ReviewListResponseDto findById(int id){
        MovieReview entity = movieReviewRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new ReviewListResponseDto(entity);
    }

    @Transactional
    public int update(int id, ReviewUpdateRequestDto requestDto){
        MovieReview entity = movieReviewRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        MovieInfo movieInfo = movieInfoRepository.findById(requestDto.getMovieId()).orElseThrow(() -> new IllegalArgumentException("해당 영화이름이 존재하지 않습니다."));
        requestDto.setMovieInfo(movieInfo);
        entity.update(requestDto.getTitle(),requestDto.getContent(),requestDto.getScore(),requestDto.getOpenYn(),requestDto.getModifyDate(),requestDto.getMovieInfo());

        return id;
    }

    @Transactional
    public void delete (int id){
        MovieReview entity = movieReviewRepository.findById(id).orElseThrow(() -> new
                        IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        movieReviewRepository.delete(entity);
    }

    @Transactional
    public int updateView(int id){
        return movieReviewRepository.updateView(id);
    }
}
