package com.jiangls.structuralpattern.decorator;

/**
 * 斜体功能Decorator
 */
public class ItalicDecorator extends NodeDecorator {
    public ItalicDecorator(TextNode target) {
        super(target);
    }

    public String getText() {
        return "<i>" + target.getText() + "</i>";
    }
}