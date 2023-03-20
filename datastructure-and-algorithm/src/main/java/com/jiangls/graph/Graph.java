package com.jiangls.graph;

/**
 * 图接口，图接口可由邻接矩阵和邻接表实现
 * <ol>
 *     <li>邻接矩阵：图的邻接矩存储结构中，顶点信息使用一维数组存储，边信息的邻接矩阵使用二维数组存储。</li>
 *     <li>邻接表：对于图中的每个顶点Vi，把所有的邻接与Vi的顶点Vj链成一个带头节点的单链表，这个单链表就称为顶点Vi的邻接表。</li>
 *     <li>参考：https://www.icourse163.org/learn/CCIT-1461552162?tid=1463292527#/learn/content?type=detail&id=1240727497&cid=1262487282</li>
 * </ol>
 * @author Jiangls
 * @date 2023/3/20
 */
public interface Graph<T> {
    /**
     * 返回顶点个数
     * @return
     */
    int getNumOfVertices();

    /**
     * 返回边数量
     * @return
     */
    int getNumOfEdges();

    T getValue(int v) throws Exception;

    int getWeight(int v1, int v2) throws Exception;

    void insertVertex(T vertex) throws Exception;

    void insertEdge(int v1, int v2, int weight) throws Exception;

    void delEdge(int v1, int v2) throws Exception;

    /**
     * 取顶点v的第一个邻接顶点，若存在返回该顶点的下标序号，否则返回-1
     * @param v
     * @return
     * @throws Exception
     */
    int getFirstNeighbor(int v) throws Exception;

    /**
     * 取顶点v1邻接v2后的邻接顶点。若存在返回该顶点的下标序号，否则返回-1
     * @param v1
     * @param v2
     * @return
     * @throws Exception
     */
    int getNextNeighbor(int v1, int v2) throws Exception;

    /**
     * 深度优先遍历
     * @throws Exception
     */
    void DFS() throws Exception;

    /**
     * 广度优先遍历
     * @throws Exception
     */
    void BFS() throws Exception;



}
