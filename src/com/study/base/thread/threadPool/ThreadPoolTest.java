package com.study.base.thread.threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/16 10:42
 */
public class ThreadPoolTest {
    // 任务数
    private static int taskCount = 51;
    // 实际完成任务数
    private static AtomicInteger taskCountExecuted;

    public static void main(String[] args) {
        init();
    }

    private static void init() {
        taskCountExecuted = new AtomicInteger(0);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                10,        // 核心线程数
                20,    // 最大线程数
                5,        // 非核心线程回收超时时间
                TimeUnit.SECONDS,     // 超时时间单位
                new ArrayBlockingQueue<>(30)      // 任务队列
        );

        System.out.println("任务总数 = [" + taskCount + "]个");
        long start = System.currentTimeMillis();

        for (int i = 0; i < taskCount; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(500);
                        System.out.println("已执行第 [" + taskCountExecuted.addAndGet(1) + "] 个任务");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            };

            try {
                // 默认拒绝策略会报错
                threadPoolExecutor.execute(runnable);
            } catch (Exception ex) {
                ex.printStackTrace();
                taskCount = threadPoolExecutor.getActiveCount() + threadPoolExecutor.getQueue().size();
            }
        }

        long end = 0;
        while (threadPoolExecutor.getCompletedTaskCount() < taskCount) {
            end = System.currentTimeMillis();
        }

        System.out.println("[" + taskCountExecuted + "]个任务执行总耗时 = [" + (end - start) + "]ms");
        threadPoolExecutor.shutdown();
    }
}
