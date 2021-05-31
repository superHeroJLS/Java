package com.jiangls.structuralpattern.adapter;

import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        //想要通过一个线程执行Callable
        Callable<Long> callable = new Task(123450000L);
        //Thread thread = new Thread(callable); // compile error!
        //thread.start();

        //Callable经过RunnableAdapter后输出了一个Runable
        Thread thread = new Thread(new RunnableAdapter(callable));
        thread.start();


        /**
         * JDK中关于Adapter模式的使用：
         * 1. List<T> Arrays.asList(T[])就相当于一个转换器，它可以把数组转换为List。
         * 2. InputStreamReader就是Java标准库提供的Adapter，它负责把一个InputStream适配为Reader。
         * 3. OutputStreamWriter也类似。
         */

    }
}
