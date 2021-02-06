package com.example.lesson7;

import com.example.lesson7.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: lesson7 Method6.java
 * @description: 在 main 函数启动一个新线程，运行一个方法，拿到这个方法的返回值后，退出主线程
 * @author: cc
 * @create: 2021-02-07 00:15
 */
@Slf4j
public class Method6 {

    public static Integer result = 0;


    /**
     * 使用线程池
     * 放入对象返回
     * 主线程循环等待是否有值
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        log.info("开始");
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                log.info("延迟2s");
                CommonUtil.sleep(2000L);
                result = result+1;
            }
        });
        while (result == 0) {
            log.info("等待中");
        }
        executorService.shutdown();
        log.info("结束"+result);
    }

}
