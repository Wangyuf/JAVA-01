package com.example.lesson7;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

/**
 * @program: lesson7 Method4.java
 * @description: 在 main 函数启动一个新线程，运行一个方法，拿到这个方法的返回值后，退出主线程
 * @author: cc
 * @create: 2021-02-07 00:15
 */
@Slf4j
public class Method4 {

    /**
     * 使用completableFuture 返回
     *
     * @param args
     */
    public static void main(String[] args) {
        log.info("开始");
        String result = CompletableFuture.supplyAsync(() ->
                " a -> "
        ).thenApplyAsync(v -> v + " b -> ").join();
        log.info("结束" + result);
    }

}
