package com.example.lesson14.annotation;

import java.lang.annotation.*;

/**
 * @author hugh
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String value() default "master";
}