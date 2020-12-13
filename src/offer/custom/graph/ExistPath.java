/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.custom.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
 * 示例1:
 * <p>
 * 输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
 * 输出：true
 * 示例2:
 * <p>
 * 输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
 * 输出 true
 * 提示：
 * <p>
 * 节点数量n在[0, 1e5]范围内。
 * 节点编号大于等于 0 小于 n。
 * 图中可能存在自环和平行边。
 * <p>
 * https://leetcode-cn.com/problems/route-between-nodes-lcci/
 * https://leetcode-cn.com/problems/route-between-nodes-lcci/solution/javalin-jie-biao-yan-du-bian-li-by-wonderzlf/
 *
 * @author xingye
 * @created 2020/12/12
 */
public class ExistPath {

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        if (start == target) {
            return true;
        }

        // 转化为链接矩阵形式
        LinkedList<Integer>[] vectors = new LinkedList[n];
        for (int[] edge : graph) {
            if (vectors[edge[0]] == null) {
                vectors[edge[0]] = new LinkedList<>();
            }
            vectors[edge[0]].add(edge[1]);
        }

        return existPath(vectors, start, target);
    }

    private boolean existPath(LinkedList<Integer>[] vectors, int start, int target) {
        if (start == target) {
            return true;
        }

        boolean[] visited = new boolean[vectors.length];
        Queue<Integer> queue = new LinkedList<>();
        // 从start出发
        queue.add(start);
        // 入队的顶点做好标记
        visited[start] = true;

        while (!queue.isEmpty()) {
            Integer curPoint = queue.poll();
            if (null == vectors[curPoint]) {
                continue;
            }
            for (Integer nextPoint : vectors[curPoint]) {
                if (visited[nextPoint]) {
                    continue;
                }
                if (nextPoint == target) {
                    return true;
                }
                queue.add(nextPoint);
            }
        }

        return false;
    }

    public static void main(String... args) {
        ExistPath existPath = new ExistPath();
        int[][] graph = new int[][]{{0, 1}, {1, 2}, {1, 3}, {1, 10}, {1, 11}, {1, 4}, {2, 4}, {2, 6}, {2, 9}, {2, 10}, {2, 4}, {2, 5}, {2, 10}, {3, 7}, {3, 7}, {4, 5}, {4, 11}, {4, 11}, {4, 10}, {5, 7}, {5, 10}, {6, 8}, {7, 11}, {8, 10}};
        System.out.println(existPath.findWhetherExistsPath(12, graph, 2, 3));
    }
}