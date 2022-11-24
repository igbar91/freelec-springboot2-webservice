package com.jojoldu.book.springboot.service.movieInfo;

import com.jojoldu.book.springboot.domain.MovieInfo.MovieInfo;
import com.jojoldu.book.springboot.domain.MovieInfo.MovieInfoRepository;
import com.jojoldu.book.springboot.web.Dto.MovieInfoListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MovieInfoService {

    private final MovieInfoRepository movieInfoRepository;

    @Transactional(readOnly = true)
    public List<MovieInfoListResponseDto> findAllDesc(){
        return movieInfoRepository.findAllDesc().stream()
                .map(MovieInfoListResponseDto::new)
                .collect(Collectors.toList());
    }

    public MovieInfoListResponseDto findById(int id){
        MovieInfo entity = movieInfoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new MovieInfoListResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public int getAllCount(){
        return movieInfoRepository.getAllCount();
    }


}
