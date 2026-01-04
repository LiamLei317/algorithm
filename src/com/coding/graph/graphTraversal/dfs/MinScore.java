package com.coding.graph.graphTraversal.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 两个城市间路径的最小分数
 * index:2492
 * <a href="https://leetcode.cn/problems/minimum-score-of-a-path-between-two-cities/description/">...</a>
 */
public class MinScore {

    int ans = Integer.MAX_VALUE;
    int n;

    public int minScore(int n, int[][] roads) {
        this.n = n;
        // 构建邻接表
        List<int[]>[] g = new ArrayList[n + 1]; // 节点编号从1开始，所以数组长度为n+1
        Arrays.setAll(g, i -> new ArrayList<>());
        // 填充数据
        for (int[] road : roads) {
            g[road[0]].add(new int[]{road[1], road[2]});
            g[road[1]].add(new int[]{road[0], road[2]});
        }
        dfs(g, 1, new boolean[n + 1]);
        return ans;
    }

    private void dfs(List<int[]>[] g, int x, boolean[] visited) {
        System.out.println(x);
        visited[x] = true;
        for (int[] next : g[x]) {
            ans = Math.min(ans, next[1]);
            if (!visited[next[0]]) {
                dfs(g, next[0], visited);
            }
        }
    }

}
