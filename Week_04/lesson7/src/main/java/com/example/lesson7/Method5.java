package com.example.lesson7;

import com.example.lesson7.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: lesson7 Method5.java
 * @description: 在 main 函数启动一个新线程，运行一个方法，拿到这个方法的返回值后，退出主线程
 * @author: cc
 * @create: 2021-02-07 00:15
 */
@Slf4j
public class Method5 {

    private static String result;

    /**
     * 对象包装返回，使用join阻塞主线程等待返回值
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        log.info("开始" + result);
        Thread thread = new Thread(() -> {
            CommonUtil.sleep(2000L);
            result = "hello world";
        });
        thread.start();
        thread.join();
        log.info("结束" + result);
    }

}
