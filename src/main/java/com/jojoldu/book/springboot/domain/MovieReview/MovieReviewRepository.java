package com.jojoldu.book.springboot.domain.MovieReview;


import com.jojoldu.book.springboot.domain.MovieInfo.MovieInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface MovieReviewRepository extends JpaRepository<MovieReview, Integer>{

    List<MovieReview> findTop4ByOrderByRegDateDesc();

    @Query("SELECT COUNT(*) From MovieReview a where a.openYn = 'Y'")
    int getAllCountByOpenYn();

    @Query("SELECT a From MovieReview a where a.openYn = 'Y'")
    Page<MovieReview> findAllByOpenYn(Pageable pageable);

    @Query("SELECT COUNT(*) From MovieReview a Where a.userId = :userId")
    int getAllCountByUserId(@Param("userId") String userId);

    @Query("SELECT a From MovieReview a Where a.userId = :userId")
    Page<MovieReview> findAllByUserId(Pageable pageable, @Param("userId") String userId);

    @Modifying
    @Query("update MovieReview a set a.viewCount = a.viewCount + 1 where a.id = :id")
    int updateView(@Param("id") int id);


}