/*
 * Copyright (c) 2015—2030 GantSoftware.Co.Ltd. All rights reserved.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * is not allowed to be distributed or copied without the license from
 * GantSoftware.Co.Ltd. Please contact the company for more information.
 */
package com.jiangls.reference;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * @Author jiangls
 * @Date 2021/7/21
 */
public class Order {
    private String orderCode;
    private Goods goods;
    private WeakReference<Goods> goodsRef;

    public Order() {
    }

    public Order(Goods goods, WeakReference<Goods> goodsRef) {
        this.goods = goods;
        this.goodsRef = goodsRef;
    }

    public WeakReference<Goods> getGoodsRef() {
        return goodsRef;
    }

    public void setGoodsRef(WeakReference<Goods> goodsRef) {
        this.goodsRef = goodsRef;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
