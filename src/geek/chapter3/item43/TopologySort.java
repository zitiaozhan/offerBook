/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package geek.chapter3.item43;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 拓扑排序
 * <p>
 * 我们知道，一个完整的项目往往会包含很多代码源文件。
 * 编译器在编译整个项目的时候，需要按照依赖关系，依次编译每个源文件。
 * 比如，A.cpp 依赖 B.cpp，那在编译的时候，编译器需要先编译 B.cpp，才能编译 A.cpp。
 * 编译器通过分析源文件或者程序员事先写好的编译配置文件（比如 Makefile 文件），来获取这种局部的依赖关系。
 * 那编译器又该如何通过源文件两两之间的局部依赖关系，确定一个全局的编译顺序呢？
 *
 * @author xinyeguo
 * @created 2020/11/6
 */
public class TopologySort {

    /**
     * 有向图使用邻接表方式存储
     * 1 --> 2 表示 1依赖于2
     */
    private static class Graph {
        // 顶点个数
        private int size;
        // 邻接表
        private LinkedList<Integer>[] vectors;

        public Graph(int size) {
            this.size = size;
            vectors = new LinkedList[size];
            for (int i = 0; i < size; i++) {
                vectors[i] = new LinkedList<>();
            }
        }
    }

    private List<Integer> dfs(Graph graph) {
        List<Integer> sortList = new ArrayList<>();
        boolean[] visited = new boolean[graph.size];

        for (int vertex = 0; vertex < graph.size; vertex++) {
            if (visited[vertex]) {
                continue;
            }
            visited[vertex] = true;
            dfsCore(vertex, graph, sortList, visited);
        }

        return sortList;
    }

    private void dfsCore(int vertex, Graph graph, List<Integer> sortResult, boolean[] visited) {
        for (Integer vertexIndex : graph.vectors[vertex]) {
            if (visited[vertexIndex]) {
                continue;
            }
            visited[vertexIndex] = true;
            dfsCore(vertexIndex, graph, sortResult, visited);
        }
        sortResult.add(vertex);
    }

    private List<Integer> sortByKahn(Graph graph) {
        List<Integer> sortList = new ArrayList<>();
        // 顶点出度
        int[] outDegrees = new int[graph.size];
        for (int vertex = 0; vertex < graph.size; vertex++) {
            outDegrees[vertex] = graph.vectors[vertex].size();
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int vertex = 0; vertex < graph.size; vertex++) {
            if (outDegrees[vertex] == 0) {
                // 出度为0的加入队列
                queue.add(vertex);
            }
        }

        while (!queue.isEmpty()) {
            Integer vertex = queue.remove();
            sortList.add(vertex);
            for (int i = 0; i < graph.size; i++) {
                if (i == vertex) {
                    continue;
                }
                for (Integer val : graph.vectors[i]) {
                    if (val.equals(vertex)) {
                        outDegrees[i]--;
                        if (outDegrees[i] == 0) {
                            queue.add(i);
                        }
                        break;
                    }
                }
            }
        }
        return sortList;
    }

    private Graph initGraph() {
        Graph graph = new Graph(3);
        graph.vectors[0].add(1);
        graph.vectors[0].add(2);
        graph.vectors[1].add(2);
        return graph;
    }

    public static void main(String... args) {
        TopologySort topologySort = new TopologySort();
        Graph graph = topologySort.initGraph();
        System.out.println(topologySort.dfs(graph));
        System.out.println(topologySort.sortByKahn(graph));
    }
}