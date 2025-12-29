package com.coding.graph.graphTraversal.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 寻找图中是否存在路径
 * index:1971
 * <a href="https://leetcode.cn/problems/find-if-path-exists-in-graph/">...</a>
 */
public class ValidPath {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // 构建邻接表
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 从每个节点出发构建一个链表
            graph.add(new ArrayList<>());
        }
        // 添加元素
        for (int[] edge : edges) {
            // 由于是无向边，所以两个节点都添加
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        // 已访问数组
        boolean[] visited = new boolean[n];
        return dfs(source, graph, destination, visited);
    }

    public boolean dfs(int curNode, List<List<Integer>> graph, int destination, boolean[] visited) {
        if (curNode == destination) {
            return true;
        }
        visited[curNode] = true;
        for (int nextNode : graph.get(curNode)) {
            // 递归调用，在这里判断是否已访问，外面就不用判断 curNode 了，因为 nextNode 一定没有被访问过
            if (!visited[nextNode] && dfs(nextNode, graph, destination, visited)) {
                return true;
            }
        }
        return false;
    }
}
