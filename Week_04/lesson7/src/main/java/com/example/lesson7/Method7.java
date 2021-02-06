package com.example.lesson7;

import com.example.lesson7.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @program: lesson7 Method7.java
 * @description: 在 main 函数启动一个新线程，运行一个方法，拿到这个方法的返回值后，退出主线程
 * @author: cc
 * @create: 2021-02-07 00:15
 */
@Slf4j
public class Method7 {


    /**
     * 使用线程池
     * 对象包装返回，使用awaitTermination阻塞主线程等待返回值
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        log.info("开始");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                CommonUtil.sleep(2000L);
                log.info("等待2s");
            }
        });
        executorService.awaitTermination(3, TimeUnit.SECONDS);
        executorService.shutdown();

        log.info("结束值");
    }
}
