package com.jiangls.structuralpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 对于普通文本，我们把它看作TextNode，它没有子节点
 */
public class TextNode implements Node {
    private String text;

    public TextNode(String text) {
        this.text = text;
    }

    public Node add(Node node) {
        throw new UnsupportedOperationException();
    }

    public List<Node> children() {
        return new ArrayList<>();
    }

    public String toXml() {
        return text;
    }
}