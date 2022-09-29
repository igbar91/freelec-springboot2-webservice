package com.jojoldu.book.springboot.domain.GenreInfo;


import com.jojoldu.book.springboot.domain.MovieInfo.MovieInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Getter
@NoArgsConstructor
@Entity
public class GenreInfo {

    @Id
    private int id;

    @Column(length = 50, nullable = false)
    private String genre;

    @Builder
    public GenreInfo(int id, String genre){
        this.id = id;
        this.genre = genre;

    }
}
