package com.wds.schedule.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * @author : TenYun
 * @date : 2019-06-18 14:49
 * @description :
 **/
@Component
public class Task {

    public static Random random = new Random();

    @Async("taskExecutor")
    public Future<String> doTaskOne() throws Exception {
        System.out.println("开始任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务一, 耗时: " + (end - start) + "毫秒");
        return new AsyncResult<>("任务一完成");
    }

    @Async("taskExecutor")
    public Future<String> doTaskTwo() throws Exception {
        System.out.println("开始任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务二, 耗时: " + (end - start) + "毫秒");
        return new AsyncResult<>("任务二完成");
    }

    @Async("taskExecutor")
    public Future<String> doTaskThree() throws Exception {
        System.out.println("开始任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务三, 耗时: " + (end - start) + "毫秒");
        return new AsyncResult<>("任务三完成");
    }

}
