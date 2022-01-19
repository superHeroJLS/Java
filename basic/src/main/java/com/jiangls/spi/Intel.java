package com.jiangls.spi;

/**
 * @author Jiangls
 * @date 2022/1/19
 */
public class Intel implements CPU {
    @Override
    public void getName() {
        System.out.println("Intel");
    }
}
