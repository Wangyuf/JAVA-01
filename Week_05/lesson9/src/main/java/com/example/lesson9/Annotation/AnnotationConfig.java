package com.example.lesson9.Annotation;

import com.example.lesson9.bean.Commodity;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @program: lesson9 AnnotationConfig.java
 * @description:
 * @author: cc
 * @create: 2021-02-21 02:56
 */
@Component
public class AnnotationConfig {

    @Bean
    public Commodity commodity1() {
        return new Commodity(1L, BigDecimal.valueOf(10.00), BigDecimal.valueOf(1.00));
    }

    @Bean(name = "commodity123")
    public Commodity commodity2() {
        return new Commodity(2L, BigDecimal.valueOf(10.00), BigDecimal.valueOf(2.00));
    }

}
