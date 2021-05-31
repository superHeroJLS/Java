package com.jiangls.behavioralpattern.observer;

/**
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) throws Exception {
		asynchronousAnnotation();
	}

	/**
	 * 通知同步发送，被观察者给观察者发送一个通知，观察者消费完成，观察者再次将通知发送给下一个观察者
	 */
	public static void synchronousAnnotation() {
		// observer:
		Admin a = new Admin();
		Customer c = new Customer();
		// store:
		Store store = new Store();
		// register:
		store.addObserver(a);
		store.addObserver(c);
		// 注册匿名观察者:
		store.addObserver(new ProductObserver() {
			@Override
			public void onPublished(Product product) {
				System.out.println("[Log] on product published: " + product);
			}

			@Override
			public void onPriceChanged(Product product) {
				System.out.println("[Log] on product price changed: " + product);
			}
		});
		// operation:
		store.addNewProduct("Design Patterns", 35.6);
		store.addNewProduct("Effective Java", 50.8);
		store.setProductPrice("Design Patterns", 31.9);
	}

	/**
	 * 通知异步发送，被观察者给观察者发送一个通知，不等观察者消费完成，直接给下一个观察者发送通知
	 * 使用多线程实现通知异步发送的功能
	 */
	public static void asynchronousAnnotation() throws Exception {
		// observer:
		Admin a = new Admin();
		Customer c = new Customer();
		// store:
		StoreOfAsynchronousAnnotation store = new StoreOfAsynchronousAnnotation();
		// register:
		store.addObserver(a);
		store.addObserver(c);
		// 注册匿名观察者:
		store.addObserver(new ProductObserver() {
			@Override
			public void onPublished(Product product) {
				System.out.println("[Log] on product published: " + product);
			}

			@Override
			public void onPriceChanged(Product product) {
				System.out.println("[Log] on product price changed: " + product);
			}
		});
		// operation:
		store.addNewProduct("Design Patterns", 35.6);
		store.addNewProduct("Effective Java", 50.8);
		store.setProductPrice("Design Patterns", 31.9);

		store.close();
	}
}

class Customer implements ProductObserver {

	@Override
	public void onPublished(Product product) {
		System.out.println("[Customer] on product published: " + product);
	}

	@Override
	public void onPriceChanged(Product product) {
		System.out.println("[Customer] on product price changed: " + product);
	}
}

class Admin implements ProductObserver {

	@Override
	public void onPublished(Product product) {
		System.out.println("[Admin] on product published: " + product);
	}

	@Override
	public void onPriceChanged(Product product) {
		System.out.println("[Admin] on product price changed: " + product);
	}
}
