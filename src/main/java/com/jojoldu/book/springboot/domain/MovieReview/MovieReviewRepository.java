package com.jojoldu.book.springboot.domain.MovieReview;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieReviewRepository extends JpaRepository<MovieReview, Long>{

    @Query("SELECT a From MovieReview a ORDER BY a.id desc")
    List<MovieReview> findAllDesc();

    @Query("SELECT COUNT(*) From MovieReview a")
    Long getAllCount();
}