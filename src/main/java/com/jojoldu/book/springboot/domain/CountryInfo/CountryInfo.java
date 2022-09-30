package com.jojoldu.book.springboot.domain.CountryInfo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class CountryInfo{

    @Id
    private int id;

    @Column(length = 10, nullable = false)
    private String code2;

    @Column(length = 50, nullable = false)
    private String codeKr;

    @Column(length = 50, nullable = false)
    private String codeEn;


    @Builder
    public CountryInfo(int id, String code2, String codeKr, String codeEn){
        this.id = id;
        this.code2 = code2;
        this.codeKr = codeKr;
        this.codeEn = codeEn;
    }
}

