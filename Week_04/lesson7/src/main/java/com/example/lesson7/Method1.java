package com.example.lesson7;

import com.example.lesson7.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: lesson7 Method1.java
 * @description: 在 main 函数启动一个新线程，运行一个方法，拿到这个方法的返回值后，退出主线程
 * @author: cc
 * @create: 2021-02-07 00:15
 */
@Slf4j
public class Method1 {

    public static String result = null;


    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            CommonUtil.sleep(1000L);
            result = "hello world";
        }).start();
        while (result == null) {
            log.info("waiting");
        }
        log.info("程序结束"+ Method1.result);
    }

}
