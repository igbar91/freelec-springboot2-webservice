package com.jojoldu.book.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;



@Configuration
@EnableJpaAuditing //JPA Auditing 활성화 > createDate, modifyDate :page:222
public class JpaConfig {
}
