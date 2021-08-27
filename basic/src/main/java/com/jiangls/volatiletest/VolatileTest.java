package com.jiangls.volatiletest;

import java.util.Arrays;

/**
 * <b>volatile变量在多线程中保证可见性和有序性，但是不保证原子性。</b>
 *
 * <p>这段代码发起了200个线程，每个线程对race变量进行10000次自增操作，如果这段代码能够正确并发的话，最后输出的结果应该是200000。
 * 读者运行完这段代码之后，并不会获得期望的结果，而且会发现每次运行程序，输出的结果都不一样，都是一个小于200000的数字。这是为什么呢？</p>
 *
 * <p>  问题就出在自增运算“race++”之中，我们用Javap反编译这段代码后会得到如下代码清单，发现只有一行代码的increase()方法
 * 在Class文件中是由4条字节码指令构成（return指令不是由race++产生的，这条指令可以不计算），从字节码层面上已经很容易分析出并发失败的原因了：
 * 当getstatic指令把race的值取到操作栈顶时，volatile关键字保证了race的值在此时是正确的，但是在执行iconst_1、iadd这些指令的时候，
 * 其他线程可能已经把race的值改变了，而操作栈顶的值就变成了过期的数据，所以putstatic指令执行后就可能把较小的race值同步回主内存之中。
 * <blockquote><pre>
 *     反编译得到的代码：
 *     public static void increase();
 *     Code:        Stack=2, Locals=0, Args_size=0
 *     0:   getstatic       #13; //Field race:I
 *     3:   iconst_1
 *     4:   iadd
 *     5:   putstatic       #13; //Fieldrace:I
 *     8:   return
 *     LineNumberTable:
 *     line 14: 0
 *     line 15: 8
 * </pre></blockquote>
 *
 * @Author jiangls
 * @Date 2021/8/27
 */
public class VolatileTest {
    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    private static final int THREAD_COUNT = 200;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];
        for(int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }

        // main线程等待所有累加线程结束
        Arrays.stream(threads).forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(race);
    }
}
