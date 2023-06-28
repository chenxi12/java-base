package com.study.base.thread.call;

import java.util.concurrent.*;

/**
 * @Description：
 * @Author：libing
 * @Date：2023/6/19 15:01
 */
public class CallTest {
    static class CallFutureTest implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "hello";
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(20, 30, 300, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(20));

        for (int i = 0; i < 10; i++) {
            try {
                Future<String> submit = executor.submit(new CallFutureTest());
                System.out.println(submit.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}
