package com.jiangls.behavioralpattern.observer;

public interface ProductObserver {

	void onPublished(Product product);

	void onPriceChanged(Product product);
}
