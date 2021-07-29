package com.jiangls;

import com.redislabs.redisgraph.Record;
import com.redislabs.redisgraph.RedisGraphContext;
import com.redislabs.redisgraph.RedisGraphTransaction;
import com.redislabs.redisgraph.ResultSet;
import com.redislabs.redisgraph.graph_entities.Edge;
import com.redislabs.redisgraph.graph_entities.Node;
import com.redislabs.redisgraph.graph_entities.Path;
import com.redislabs.redisgraph.impl.api.RedisGraph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author jiangls
 * @Date 2021/7/29
 */
public class RedisGraphDemo {

    public static void main(String[] args) {
        // call query()
//        query();

        // call transaction()
        transaction();
    }

    public static RedisGraph getRedisGraph() {
        /**
         * general context api. Not bound to graph key or connection
         *
         * 192.168.4.153是一台虚拟机，使用docker运行了一个RedisGraph实例
         */
        return new RedisGraph("192.168.4.153", 6379);
    }

    public static void closeRedisGraph(RedisGraph redisGraph) {
        if (redisGraph != null) {
            redisGraph.close();
        }
    }

    public static void query() {
        RedisGraph graph = getRedisGraph();

        Map<String, Object> params = new HashMap<>();
        params.put("age", 30);
        params.put("name", "amit");

        // send queries to a specific graph called "social"
        graph.query("social","CREATE (:person{name:'roi',age:32})");
        graph.query("social","CREATE (:person{name:$name,age:$age})", params);
        graph.query("social","MATCH (a:person), (b:person) WHERE (a.name = 'roi' AND b.name='amit') CREATE (a)-[:knows]->(b)");

        ResultSet resultSet = graph.query("social", "MATCH (a:person)-[r:knows]->(b:person) RETURN a, r, b");
        while(resultSet.hasNext()) {
            Record record = resultSet.next();
            // get values
            Node a = record.getValue("a");
            Edge r =  record.getValue("r");

            //print record
            System.out.println(record.toString());
        }

        resultSet = graph.query("social", "MATCH p = (:person)-[:knows]->(:person) RETURN p");
        while(resultSet.hasNext()) {
            Record record = resultSet.next();
            Path p = record.getValue("p");

            // More path API at Javadoc.
            System.out.println(p.nodeCount());
        }

        // delete graph
//        graph.deleteGraph("social");

        // close RedisGraph
        closeRedisGraph(graph);
    }

    public static void transaction() {
        RedisGraph graph = getRedisGraph();

        Map<String, Object> params = new HashMap<>();
        params.put("age", 30);
        params.put("name", "amit");

        // get connection context - closable object
        try(RedisGraphContext context = graph.getContext()) {
            context.query("contextSocial","CREATE (:person{name:'roi',age:32})");
            context.query("social","CREATE (:person{name:$name,age:$age})", params);
            context.query("contextSocial", "MATCH (a:person), (b:person) WHERE (a.name = 'roi' AND b.name='amit') CREATE (a)-[:knows]->(b)");
            // WATCH/MULTI/EXEC
            context.watch("contextSocial");
            RedisGraphTransaction t = context.multi();
            t.query("contextSocial", "MATCH (a:person)-[r:knows]->(b:person{name:$name,age:$age}) RETURN a, r, b", params);
            // support for Redis/Jedis native commands in transaction
            t.set("x", "1");
            t.get("x");
            // get multi/exec results
            List<Object> execResults =  t.exec();
            System.out.println(execResults.toString());

            context.deleteGraph("contextSocial");
        }

        // close RedisGraph
        closeRedisGraph(graph);
    }


}
