package com.example.lesson7.util;

/**
 * @program: lesson7 CommonUtil.java
 * @description:
 * @author: cc
 * @create: 2021-02-07 00:48
 */
public class CommonUtil {

    public static void sleep(Long m){
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
