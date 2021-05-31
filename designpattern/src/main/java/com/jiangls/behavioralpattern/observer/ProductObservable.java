package com.jiangls.behavioralpattern.observer;

public interface ProductObservable {
    //添加一个观察者
    void addObserver(ProductObserver observer);

    //删除一个观察者
    void removeObserver(ProductObserver observer);
}
