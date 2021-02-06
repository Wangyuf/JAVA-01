package com.example.lesson7;

import com.example.lesson7.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: lesson7 Method7.java
 * @description: 在 main 函数启动一个新线程，运行一个方法，拿到这个方法的返回值后，退出主线程
 * @author: cc
 * @create: 2021-02-07 00:15
 */
@Slf4j
public class Method10 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        log.info("开始");
        FutureTask<String> task = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("2 秒后返回结果");
                CommonUtil.sleep(2000L);
                return "hello world";
            }
        });
        new Thread(task).start();
        log.info("结果" + task.get());
    }
}
