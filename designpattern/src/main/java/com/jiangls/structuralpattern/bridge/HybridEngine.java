package com.jiangls.structuralpattern.bridge;

/**
 * 针对每一种引擎，继承自Engine，例如HybridEngine
 */
public class HybridEngine implements Engine {
    public void start() {
        System.out.println("Start Hybrid Engine...");
    }
}
