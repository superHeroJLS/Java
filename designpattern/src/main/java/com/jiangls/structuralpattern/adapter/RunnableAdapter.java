package com.jiangls.structuralpattern.adapter;

import java.util.concurrent.Callable;

/**
 * RunnableAdapter类就是Adapter，它接收一个Callable，输出一个Runnable
 */
public class RunnableAdapter implements Runnable{
    private Callable<?> callable;

    public RunnableAdapter(Callable<?> callable) {
        this.callable = callable;
    }

    @Override
    public void run() {
        // 将指定接口调用委托给转换接口调用:
        try {
            callable.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
