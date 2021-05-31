package com.jiangls.structuralpattern.decorator;

/**
 * 加粗功能Decorator
 */
public class BoldDecorator extends NodeDecorator {
    public BoldDecorator(TextNode target) {
        super(target);
    }

    public String getText() {
        return "<b>" + target.getText() + "</b>";
    }
}