package com.jiangls.structuralpattern.composite;

public class Client {
    public static void main(String[] args) {
        //通过ElementNode、TextNode和CommentNode，我们就可以构造出一颗树
        Node root = new ElementNode("school");
        root.add(new ElementNode("classA")
                .add(new TextNode("Tom"))
                .add(new TextNode("Alice")));
        root.add(new ElementNode("classB")
                .add(new TextNode("Bob"))
                .add(new TextNode("Grace"))
                .add(new CommentNode("comment...")));
        System.out.println(root.toXml());
    }
}
