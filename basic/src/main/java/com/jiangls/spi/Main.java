package com.jiangls.spi;

import java.util.ServiceLoader;

/**
 * @author Jiangls
 * @date 2022/1/19
 */
public class Main {
    public static void main(String[] args) {
        ServiceLoader<CPU> cpus = ServiceLoader.load(CPU.class);
        for (CPU cpu : cpus) {
            cpu.getName();
        }
    }
}
