package com.jiangls.graph;

/**
 * @author Jiangls
 * @date 2023/3/21
 */
public class Main {
    public static void main(String[] args) throws Exception {
        testBFS();
    }

    /**
     * 测试广度优先遍历
     * @throws Exception
     */
    public static void testBFS() throws Exception {
        // 创建图
        int n = 5, e = 4;
        AdjacentMatrixGraph<String> amGraph = new AdjacentMatrixGraph<>(n);
        String[] vertices = {"a", "b", "c", "d", "e"};
        AdjacentMatrixGraph.Edge[] edges = {
                new AdjacentMatrixGraph.Edge(0,1,1),
                new AdjacentMatrixGraph.Edge(0,3,1),
                new AdjacentMatrixGraph.Edge(1,2,1),
                new AdjacentMatrixGraph.Edge(3,4,1)
                /*new AdjacentMatrixGraph.Edge(0,1,1),
                new AdjacentMatrixGraph.Edge(0,4,1),
                new AdjacentMatrixGraph.Edge(1,4,1),
                new AdjacentMatrixGraph.Edge(4,2,1),
                new AdjacentMatrixGraph.Edge(4,3,1),
                new AdjacentMatrixGraph.Edge(3,2,1)*/};
        createAdjacentMatrixGraph(amGraph, vertices, n, edges, e);
        // 深度优先遍历
        System.out.println("广度优先遍历：");
        amGraph.BFS();
    }

    /**
     * 测试深度优先遍历
     * @throws Exception
     */
    public static void testDFS() throws Exception {
        // 创建图
        int n = 5, e = 4;
        AdjacentMatrixGraph<String> amGraph = new AdjacentMatrixGraph<>(n);
        String[] vertices = {"a", "b", "c", "d", "e"};
        AdjacentMatrixGraph.Edge[] edges = {
                new AdjacentMatrixGraph.Edge(0,1,1),
                new AdjacentMatrixGraph.Edge(0,3,1),
                new AdjacentMatrixGraph.Edge(1,2,1),
                new AdjacentMatrixGraph.Edge(3,4,1)
                /*new AdjacentMatrixGraph.Edge(0,1,1),
                new AdjacentMatrixGraph.Edge(0,4,1),
                new AdjacentMatrixGraph.Edge(1,4,1),
                new AdjacentMatrixGraph.Edge(4,2,1),
                new AdjacentMatrixGraph.Edge(4,3,1),
                new AdjacentMatrixGraph.Edge(3,2,1)*/};
        createAdjacentMatrixGraph(amGraph, vertices, n, edges, e);
        // 深度优先遍历
        System.out.println("深度优先遍历：");
        amGraph.DFS();
    }

    /**
     * 测试图遍历
     * @throws Exception
     */
    public static void testIterator() throws Exception {
        // 创建图
        int n = 5, e = 6;
        AdjacentMatrixGraph<String> amGraph = new AdjacentMatrixGraph<>(n);
        String[] vertices = {"a", "b", "c", "d", "e"};
        AdjacentMatrixGraph.Edge[] edges = {
                new AdjacentMatrixGraph.Edge(0,1,8),
                new AdjacentMatrixGraph.Edge(0,4,9),
                new AdjacentMatrixGraph.Edge(1,4,7),
                new AdjacentMatrixGraph.Edge(4,2,10),
                new AdjacentMatrixGraph.Edge(4,3,20),
                new AdjacentMatrixGraph.Edge(3,2,30)};
        createAdjacentMatrixGraph(amGraph, vertices, n, edges, e);
        // 输出邻接矩阵二维数组
        System.out.println("初始情况：");
        System.out.println("顶点个数：" + amGraph.getNumOfVertices() + " 边个数：" + amGraph.getNumOfEdges());
        print(amGraph.getMatrix());
        // 删除一条边
        amGraph.delEdge(4, 2);
        // 输出邻接矩阵二维数组
        System.out.println("删除边后：");
        System.out.println("顶点个数：" + amGraph.getNumOfVertices() + " 边个数：" + amGraph.getNumOfEdges());
        print(amGraph.getMatrix());
    }

    /**
     * 创建图（可以是无向图和有向图，创建过程无差别，仅仅是图中邻接矩阵二维数组有差别）
     * @param g 图
     * @param vertices 顶点
     * @param vNum 顶点数量
     * @param edges 边
     * @param eNum 边数量
     * @throws Exception
     */
    public static void createAdjacentMatrixGraph(AdjacentMatrixGraph<String> g, String[] vertices, int vNum,
                                                 AdjacentMatrixGraph.Edge[] edges, int eNum) throws Exception {
        for(int k = 0; k < vNum; k++) {
            g.insertVertex(vertices[k]);
        }
        for(int k = 0; k < eNum; k++) {
            g.insertEdge(edges[k].i, edges[k].j, edges[k].weight);
        }
    }

    public static  void print(int[][] matrix) {
        System.out.println("邻接矩阵二位数组：");
        for(int i = 0;i<matrix.length;i++) {
            System.out.print("|");
            for(int j = 0;j<matrix[i].length;j++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println("|");
        }
    }
}
