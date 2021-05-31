package com.jiangls.structuralpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 还可以有注释节点
 */
public class CommentNode implements Node {
    private String text;

    public CommentNode(String text) {
        this.text = text;
    }

    public Node add(Node node) {
        throw new UnsupportedOperationException();
    }

    public List<Node> children() {
        return new ArrayList<>();
    }

    public String toXml() {
        return "<!-- " + text + " -->";
    }
}