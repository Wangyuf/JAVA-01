package com.example.lesson9.Annotation;

import com.example.lesson9.bean.Commodity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: lesson9 AnnotationDemo.java
 * @description:
 * @author: cc
 * @create: 2021-02-21 02:56
 */
public class AnnotationDemo {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.example.lesson9");
        Commodity commodity1 = (Commodity) context.getBean("commodity1");
        System.out.println(commodity1);

        Commodity commodity2 = (Commodity) context.getBean("commodity123");
        System.out.println(commodity2);
    }

}
