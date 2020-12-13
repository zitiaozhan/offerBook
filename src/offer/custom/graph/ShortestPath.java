/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.custom.graph;

/**
 * https://blog.csdn.net/wzy_2017/article/details/78910697
 *
 * @author xingye
 * @created 2020/12/13
 */
public class ShortestPath {
    private int minPath = 0;

    private void dfs(int[][] vectors, int cur, int target, boolean[] visited, int dst) {
        if (minPath < dst) {
            // 当前路径长度不小于当前最短路径
            return;
        }
        if (cur == target) {
            if (dst < minPath) {
                // 更新最短路径
                minPath = dst;
            }
        } else {
            for (int i = 1; i < vectors.length; i++) {
                if (vectors[cur][i] > 0 && !visited[i]) {
                    // 防止路径中的环
                    visited[i] = true;
                    dfs(vectors, i, target, visited, dst + vectors[cur][i]);
                    visited[i] = false;
                }
            }
        }
    }

}