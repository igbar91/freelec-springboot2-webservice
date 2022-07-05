package com.jojoldu.book.springboot.web.Dto;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;



public class HelloResponseDtoTest {


    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        //현재버전 intelliJ 2.4 version, junit4.13, gradle 7.4
        // assertj의 assertThat은 2.2버전부터 안됨
        //assertThat(dto.getName()).isEqualTo(name);
        //asserThat(dto.getAmount()).isEqualTo(amount);
        assertThat(dto.getName(), is(equalTo(name)));
        assertThat(dto.getAmount(), is(equalTo(amount)));

    }
}
