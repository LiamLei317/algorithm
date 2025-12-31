package com.coding.graph.graphTraversal.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 统计无向图中无法互相到达点对数
 * index:2316
 * <a href="https://leetcode.cn/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/">...</a>
 */
public class CountPairs {

    private boolean[] visited;
    public long countPairs(int n, int[][] edges) {
        this.visited = new boolean[n];
        // 构建邻接表
        List<Integer>[] g = new ArrayList[n];
        // 邻接表初始化
        Arrays.setAll(g, i -> new ArrayList<>());
        int edgesNum = edges.length;
        // 构建赋值
        for (int i = 0; i < edgesNum; i++) {
            g[edges[i][0]].add(edges[i][1]);
            g[edges[i][1]].add(edges[i][0]);
        }
        long ans = 0;
        for (int i = 0, lastTotal = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                long size = dfs(g, i);
                ans += lastTotal * size;
                lastTotal += size;
            }
        }
        return ans;
    }

    public int dfs(List<Integer>[] g, int curNode) {
        // 遍历当前节点的相邻节点
        int size = 1;
        for (int nextNode : g[curNode]) {
            // 如果当前节点没有被访问过
            if (!visited[nextNode]) {
                visited[nextNode] = true;
                size += dfs(g, nextNode);
            }
        }
        return size;
    }

}
