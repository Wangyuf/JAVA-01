package com.example.lesson9.xml;

import com.example.lesson9.bean.Commodity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: lesson9 XmlDemo.java
 * @description:
 * @author: cc
 * @create: 2021-02-21 02:46
 */
public class XmlDemo {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("demo.xml");
        Commodity commodity1 = (Commodity) context.getBean("commodity1");
        System.out.println(commodity1);

        Commodity commodity2 = (Commodity) context.getBean("commodity2");
        System.out.println(commodity2);
    }

}
