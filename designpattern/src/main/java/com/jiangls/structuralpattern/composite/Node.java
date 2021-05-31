package com.jiangls.structuralpattern.composite;

import java.util.List;

/**
 * 要以树的结构表示XML，我们可以先抽象出节点类型Node
 */
public interface Node {
    // 添加一个节点为子节点:
    Node add(Node node);
    // 获取子节点:
    List<Node> children();
    // 输出为XML:
    String toXml();
}