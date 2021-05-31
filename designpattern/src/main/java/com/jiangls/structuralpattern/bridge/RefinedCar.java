package com.jiangls.structuralpattern.bridge;

/**
 * 在一个“修正”的抽象类RefinedCar中定义一些额外操作
 */
public abstract class RefinedCar extends Car {
    public RefinedCar(Engine engine) {
        super(engine);
    }

    public void drive() {
        this.engine.start();
        System.out.println("Drive " + getBrand() + " car...");
    }

    public abstract String getBrand();
}