package com.jiangls.structuralpattern.bridge;

public class Client {
    /**
     * 客户端通过自己选择一个品牌，再配合一种引擎，得到最终的Car
     */
    public static void main(String[] args) {
        RefinedCar car = new BossCar(new HybridEngine());
        car.drive();
    }
}
