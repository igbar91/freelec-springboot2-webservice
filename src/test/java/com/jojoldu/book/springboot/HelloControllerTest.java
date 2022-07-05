package com.jojoldu.book.springboot;

import com.jojoldu.book.springboot.web.HelloController;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

import org.junit.Test;


    @RunWith(SpringRunner.class)
    @WebMvcTest(controllers = HelloController.class)    //테스트 어노테이션 중 web에 집중가능한 anno
    public class HelloControllerTest {

        @Autowired
        private MockMvc mvc; //웹api 테스트 할 때 사용 + 스프링 mvc테스트의 시작점

        @Test
        public void hello가_리턴된다() throws Exception {
            String hello = "hello";

            mvc.perform(get("/hello"))
                    .andExpect(status().isOk())  // 200,400,500 등의 상태 점검
            .andExpect(content().string(hello)); //hello 값 검증
        }

        @Test
        public void helloDto가_리턴된다() throws Exception {
            String name = "hello";
            int amount = 1000;

            mvc.perform(get("/hello/dto")
                    .param("name", name)
                    .param("amount", String.valueOf(amount)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.name", is(name)))
                    .andExpect(jsonPath("$.amount", is(amount)));
        }
    }

