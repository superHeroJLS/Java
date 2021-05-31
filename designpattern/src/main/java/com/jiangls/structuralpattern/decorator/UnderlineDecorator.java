package com.jiangls.structuralpattern.decorator;

/**
 * 加粗功能Decorator
 */
public class UnderlineDecorator extends NodeDecorator {
    public UnderlineDecorator(TextNode target) {
        super(target);
    }

    public String getText() {
        return "<u>" + target.getText() + "</u>";
    }
}