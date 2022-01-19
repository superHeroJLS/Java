package com.jiangls.spi;

/**
 * @author Jiangls
 * @date 2022/1/19
 */
public class AMD implements CPU {
    @Override
    public void getName() {
        System.out.println("AMD");
    }
}
