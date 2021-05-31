package com.jiangls.structuralpattern.bridge;

/**
 * 不同品牌Car继承自RefinedCar，例如BossCar
 */
public class BossCar extends RefinedCar {
    public BossCar(Engine engine) {
        super(engine);
    }

    public String getBrand() {
        return "Boss";
    }
}
