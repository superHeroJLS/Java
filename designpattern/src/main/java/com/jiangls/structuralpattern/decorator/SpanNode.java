package com.jiangls.structuralpattern.decorator;

/**
 * 核心节点，例如<span>，它需要从TextNode直接继承
 */
public class SpanNode implements TextNode {
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return "<span>" + text + "</span>";
    }
}