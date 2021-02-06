package com.example.lesson7;

import com.example.lesson7.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @program: lesson7 Method7.java
 * @description: 在 main 函数启动一个新线程，运行一个方法，拿到这个方法的返回值后，退出主线程
 * @author: cc
 * @create: 2021-02-07 00:15
 */
@Slf4j
public class Method12 {

    private static Integer result;

    public static void main(String[] args) throws InterruptedException {
        log.info("开始");
        Thread thread = new Thread(() -> {
            result = 1;
            log.info("休眠2s");
            CommonUtil.sleep(2000L);
            Thread.currentThread().interrupt();
        });
        thread.start();
        while (!thread.isInterrupted()){
            log.info("还未中断");
        }
        log.info("结束"+result);
    }
}
