package com.jiangls.structuralpattern.decorator;

/**
 * 为了实现Decorator模式，需要有一个抽象的Decorator类
 * 这个NodeDecorator类的核心是持有一个TextNode，即将要把功能附加到的TextNode实例
 */
public abstract class NodeDecorator implements TextNode {
    protected final TextNode target;

    protected NodeDecorator(TextNode target) {
        this.target = target;
    }

    public void setText(String text) {
        this.target.setText(text);
    }
}