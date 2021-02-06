package com.example.lesson7;

import com.example.lesson7.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @program: lesson7 Method2.java
 * @description: 在 main 函数启动一个新线程，运行一个方法，拿到这个方法的返回值后，退出主线程
 * @author: cc
 * @create: 2021-02-07 00:15
 */
@Slf4j
public class Method2 implements Callable<String> {

    @Override
    public String call() throws Exception {
        CommonUtil.sleep(2000L);
        return "hello world";
    }

    /**
     * 使用线程池Future+Callable包装返回
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        log.info("开始");
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future = executorService.submit(new Method2());
        executorService.shutdown();
        log.info("结束：" + future.get());
    }

}
