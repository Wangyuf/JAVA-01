package com.example.lesson7;

import com.example.lesson7.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: lesson7 Method7.java
 * @description: 在 main 函数启动一个新线程，运行一个方法，拿到这个方法的返回值后，退出主线程
 * @author: cc
 * @create: 2021-02-07 00:15
 */
@Slf4j
public class Method8 {
    /**
     * 使用CountDownLatch返回
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        final BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>(10);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            int k = i;
            executorService.execute(() -> {
                blockingDeque.push("当前" + k);
                latch.countDown();
                log.info("wait 1s");
                CommonUtil.sleep(1000L);
            });
        }
        latch.await();
        executorService.shutdown();
        log.info("结束{}", blockingDeque);
    }
}
