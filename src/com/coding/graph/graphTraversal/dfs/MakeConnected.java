package com.coding.graph.graphTraversal.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 联通网络的操作次数
 * index:1319
 * <a href="https://leetcode.cn/problems/number-of-operations-to-make-network-connected/">...</a>
 */
public class MakeConnected {

    private boolean[] visited;

    public int makeConnected(int n, int[][] connections) {
        int connectedNum = connections.length;
        // 连线数小于 n-1 一定不能联通所有节点
        if (connectedNum < n - 1) {
            return -1;
        }
        // 构建邻接表
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] edge : connections) {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }
        this.visited = new boolean[n];
        int connectedComponents = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                connectedComponents++;
                dfs(g, i);
            }
        }
        return connectedComponents - 1;
    }

    private void dfs(List<Integer>[] g, int x) {
        visited[x] = true;
        for (int neighbor : g[x]) {
            if (!visited[neighbor]) {
                dfs(g, neighbor);
            }
        }
    }

}
