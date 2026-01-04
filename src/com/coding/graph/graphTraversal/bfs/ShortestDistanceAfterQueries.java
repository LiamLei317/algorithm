package com.coding.graph.graphTraversal.bfs;

import java.util.*;

/**
 * 新增道路查询后的最短距离I
 * index:3243
 * <a href="https://leetcode.cn/problems/shortest-distance-after-road-addition-queries-i/">...</a>
 */
public class ShortestDistanceAfterQueries {

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        // 构建邻接表
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            g[i].add(i + 1);
        }
        int qn = queries.length;
        int[] ans = new int[qn];
        int[] visited = new int[n];
        for (int i = 0; i < qn; i++) {
            g[queries[i][0]].add(queries[i][1]);
            ans[i] = bfs(g, n, visited, i + 1);
        }
        return ans;
    }

    private int bfs(List<Integer>[] g, int n, int[] visited, int round) {
        List<Integer> q = new ArrayList<>();
        q.add(0);
        for (int step = 1; ;step++) {
            List<Integer> curQ = q;
            q = new ArrayList<>();
            for (int x : curQ) {
                for (int y : g[x]) {
                    if (y == n - 1) {
                        return step;
                    }
                    // 如果节点的上一次访问轮次不同和当前轮次不同，则意味着本轮次内还没访问过
                    if (visited[y] != round) {
                        visited[y] = round;
                        q.add(y);
                    }
                }
            }
        }
    }
}
