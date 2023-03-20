package com.jiangls.graph;

import java.util.ArrayList;

/**
 * 图的邻接矩阵实现
 * @author Jiangls
 * @date 2023/3/20
 */
public class AdjacentMatrixGraph<T> implements Graph<T> {
    /**
     * 默认最大权值10000
     */
    static final int maxWeight = 10000;
    /**
     * 默认最小权值0，邻接矩阵对角线位置默认最小权值
     */
    static final int minWeight = 0;

    /**
     * 顶点的顺序表
     */
    private ArrayList<T> vertices;

    /**
     * 邻接矩阵（权值）的二维数组
     */
    private int[][] matrix;

    /**
     * 顶点数量
     */
    private int numOfVertices;

    /**
     * 边数量
     */
    private int numOfEdges;

    /**
     * 容量，不支持扩容
     */
    private int capacity;

    /**
     * @param capacity 顶点的顺序表容量，这个参数仅用来初始化顶点顺序表的容量，不支持扩容（若支持扩容的话顶点的顺序表、邻接矩阵二维数组都需要支持扩容）
     */
    public AdjacentMatrixGraph(int capacity) {
        vertices = new ArrayList<>(capacity);
        matrix = new int[capacity][capacity];
        // 初始化二维数组：对角线默认为最小权值minWeight，其他位置默认为最大权值maxWeight
        for(int i = 0; i < capacity; i++) {
            for(int j = 0; j < capacity; j++) {
                if (i == j) {
                    matrix[i][j] = minWeight;
                } else {
                    matrix[i][j] = maxWeight;
                }
            }
        }
        numOfVertices = 0;
        numOfEdges = 0;
        this.capacity = capacity;
    }

    @Override
    public int getNumOfVertices() {
        return 0;
    }

    @Override
    public int getNumOfEdges() {
        return 0;
    }

    @Override
    public T getValue(int v) throws Exception {
        return null;
    }

    @Override
    public int getWeight(int v1, int v2) throws Exception {
        return 0;
    }

    @Override
    public void insertVertex(T vertex) throws Exception {

    }

    @Override
    public void insertEdge(int v1, int v2, int weight) throws Exception {

    }

    @Override
    public void delEdge(int v1, int v2) throws Exception {

    }

    @Override
    public int getFirstNeighbor(int v) throws Exception {
        return 0;
    }

    @Override
    public int getNextNeighbor(int v1, int v2) throws Exception {
        return 0;
    }

    @Override
    public void DFS() throws Exception {

    }

    @Override
    public void BFS() throws Exception {

    }
}
