package com.jiangls.graph;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 图的邻接矩阵实现
 * @author Jiangls
 * @date 2023/3/20
 */
public class AdjacentMatrixGraph<T> implements Graph<T> {
    /**
     * 默认最大权值99999，真正边的权重一定小于maxWeight
     */
    static final int maxWeight = 99999;
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

    public int[][] getMatrix() {
        return matrix;
    }

    @Override
    public int getNumOfVertices() {
        return numOfVertices;
    }

    @Override
    public int getNumOfEdges() {
        return numOfEdges;
    }

    @Override
    public T getValue(int v) throws Exception {
        return vertices.get(v);
    }

    @Override
    public int getWeight(int v1, int v2) throws Exception {
        if (v1 < 0 || v1 >= vertices.size() || v2 < 0 || v2 >= vertices.size()) {
            throw new RuntimeException("v1或v2越界错误");
        }
        return matrix[v1][v2];
    }

    @Override
    public void insertVertex(T vertex) throws Exception {
        vertices.add(vertex);
        numOfVertices++;
    }

    @Override
    public void insertEdge(int v1, int v2, int weight) throws Exception {
        if (v1 < 0 || v1 >= vertices.size() || v2 < 0 || v2 >= vertices.size()) {
            throw new RuntimeException("v1或v2越界错误");
        }
        matrix[v1][v2] = weight;
        numOfEdges++;
    }

    @Override
    public void delEdge(int v1, int v2) throws Exception {
        if (v1 < 0 || v1 >= vertices.size() || v2 < 0 || v2 >= vertices.size()) {
            throw new RuntimeException("v1或v2越界错误");
        }
        if (matrix[v1][v2] == maxWeight || v1 == v2) {
            throw new RuntimeException("该边不存在");
        }
        matrix[v1][v2] = maxWeight;
        numOfEdges--;
    }

    @Override
    public int getFirstNeighbor(int v) throws Exception {
        if (v < 0 || v >= vertices.size()) {
            throw new RuntimeException("v越界错误");
        }
        for(int col = 0; col < vertices.size(); col++) {
            if (matrix[v][col] > 0 && matrix[v][col] < maxWeight) {
                return col;
            }
        }
        return -1;
    }

    @Override
    public int getNextNeighbor(int v1, int v2) throws Exception {
        if (v1 < 0 || v1 >= vertices.size() || v2 < 0 || v2 >= vertices.size()) {
            throw new RuntimeException("v1或v2越界错误");
        }
        for(int col = v2+1; col < vertices.size(); col++) {
            if (matrix[v1][col] > 0 && matrix[v1][col] < maxWeight) {
                return col;
            }
        }
        return -1;
    }

    @Override
    public void DFS() throws Exception {
        boolean[] visited = new boolean[getNumOfVertices()];
        for(int i = 0;i < visited.length;i++) {
            // 以顶点i为初始顶点进行深度优先遍历
            if (!visited[i]) {
                DFS(i, visited);
            }
        }
    }

    /**
     * 深度优先遍历图的连通分量
     *
     * @param v 顶点在数组中的下标
     * @param visited boolean数组，与顶点数组对应，标识顶点数组中的元素是否被访问过，false：未访问过，true 访问过
     * @throws Exception
     */
    private void DFS(int v, boolean[] visited) throws Exception {
        System.out.println(getValue(v));
        // 标记被访问过
        visited[v] = true;
        // 获得v的第一个邻接顶点
        int w = getFirstNeighbor(v);
        // 邻接顶点存在循环操作
        while(w != -1) {
            if (!visited[w]) {
                DFS(w, visited);
            }
            // 获得v的下一个邻接顶点
            w = getNextNeighbor(v, w);
        }

    }

    @Override
    public void BFS() throws Exception {
        boolean[] visited = new boolean[getNumOfVertices()];
        boolean[] enqueued = new boolean[getNumOfVertices()];
        for(int i = 0;i < visited.length;i++) {
            // 以顶点i为初始顶点进行广度优先遍历
            if (!visited[i]) {
                BFS(i, visited, enqueued);
            }
        }
    }

    /**
     * 广度优先遍历图的连通分量
     * @param v 顶点在数组中的下标
     * @param visited boolean数组，与顶点数组对应，标识顶点数组中的元素是否访问过（出队过），false：未访问过，true 访问过
     * @param enqueued boolean数组，与顶点数组对应，标识顶点数组中的元素是否入队过，false：未入队过，true 入队过
     * @throws Exception
     */
    private void BFS(int v, boolean[] visited, boolean[] enqueued) throws Exception {
        int u,w;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(v);
        enqueued[v] = true;
        while(!queue.isEmpty()) {
            u = queue.pollFirst();
            // 未出队过（访问过）顶点出队（访问）
            if (!visited[u]) {
                System.out.println(getValue(u));
                visited[u] = true;
            }
            w = getFirstNeighbor(u);
            while(w != -1) {
                // 未入队过的顶点入队
                if (!enqueued[w]) {
                    queue.addLast(w);
                    enqueued[w] = true;
                }
                w = getNextNeighbor(u, w);
            }
        }

    }

    /**
     * 带权值的边
     */
    static class Edge {
        // 邻接矩阵二维数组行下标
        public int i;
        // 邻接矩阵二维数组列下标
        public int j;
        // 权值
        public int weight;

        public Edge(int i, int j, int weight) {
            this.i = i;
            this.j = j;
            this.weight = weight;
        }
    }
}
