package com.jiangls.behavioralpattern.observer;

import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 通知异步发送，被观察者给观察者发送一个通知，不等观察者消费完成，直接给下一个观察者发送通知
 * 使用多线程实现通知异步发送的功能
 */
public class StoreOfAsynchronousAnnotation implements ProductObservable, AutoCloseable {
    private List<ProductObserver> observers = new ArrayList<>();
    private Map<String, Product> products = new HashMap<>();
    ExecutorService executorService = Executors.newCachedThreadPool();

    public void addObserver(ProductObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(ProductObserver observer) {
        this.observers.remove(observer);
    }

    public void addNewProduct(String name, double price) {
        Product p = new Product(name, price);
        products.put(p.getName(), p);
        //新创建一个线程，把通知改为异步发送
        observers.forEach(o -> executorService.submit(() -> o.onPublished(p)));
    }

    public void setProductPrice(String name, double price) {
        Product p = products.get(name);
        p.setPrice(price);
        //新创建一个线程，把通知改为异步发送
        observers.forEach(o -> executorService.submit(() -> o.onPriceChanged(p)));
    }

    @PreDestroy
    @Override
    public void close() throws Exception {
        executorService.shutdown();
    }
}
