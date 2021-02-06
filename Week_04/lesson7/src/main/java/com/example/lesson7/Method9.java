package com.example.lesson7;

import com.example.lesson7.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @program: lesson7 Method7.java
 * @description: 在 main 函数启动一个新线程，运行一个方法，拿到这个方法的返回值后，退出主线程
 * @author: cc
 * @create: 2021-02-07 00:15
 */
@Slf4j
public class Method9 implements Runnable {
    static BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>(5);
    private int id;
    private CyclicBarrier barrier;

    public Method9(int id, CyclicBarrier barrier) {
        this.id = id;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        synchronized (this) {
            blockingDeque.push("当前" + id);
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        log.info("开始");
        CyclicBarrier barrier = new CyclicBarrier(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new Method9(i, barrier)).start();
        }
        barrier.reset();
        while (Method9.blockingDeque.size() < 5){
            log.info("wait");
            Thread.sleep(100L);
        }
        log.info("结束 {}", Method9.blockingDeque);
    }
}
