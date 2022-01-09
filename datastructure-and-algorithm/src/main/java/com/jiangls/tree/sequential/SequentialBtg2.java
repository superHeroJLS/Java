package com.jiangls.tree.sequential;

import com.jiangls.tree.AbstractBt2;

/**
 * 重新定义SequentialBinaryTreeGeneric类，泛型中的N类型可以为为任何类型，比如String、Integer等
 * @author Jiangls
 * @date 2022/1/3
 */
public class SequentialBtg2<N> implements AbstractBt2<N> {

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public void preOrder() {

    }

    @Override
    public void inOrder() {

    }

    @Override
    public void postOrder() {

    }

    @Override
    public N getParent(N node) {
        return null;
    }

    @Override
    public N getLeft(N node) {
        return null;
    }

    @Override
    public N getRight(N node) {
        return null;
    }

    @Override
    public N search(N node) {
        return null;
    }

    @Override
    public void insertRoot(N node) {

    }

    @Override
    public N insertChild(N p, N t, boolean lchild) {
        return null;
    }

    @Override
    public void removeChild(N p, boolean lchild) {

    }

    @Override
    public void removeAll() {

    }
}
