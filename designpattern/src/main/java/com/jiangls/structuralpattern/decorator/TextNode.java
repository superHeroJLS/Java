package com.jiangls.structuralpattern.decorator;

/**
 * 假设我们需要渲染一个HTML的文本，但是文本还可以附加一些效果，比如加粗、变斜体、加下划线等。
 * 为了实现动态附加效果，可以采用Decorator模式。
 *
 * 定义顶层接口TextNode
 */
public interface TextNode {
    // 设置text:
    void setText(String text);
    // 获取text:
    String getText();
}