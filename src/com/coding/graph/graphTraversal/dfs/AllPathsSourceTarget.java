package com.coding.graph.graphTraversal.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 所有可能的路径
 * index:797
 * <a href="https://leetcode.cn/problems/all-paths-from-source-to-target/">...</a>
 */
public class AllPathsSourceTarget {
    // 答案
    List<List<Integer>> ans = new ArrayList<>();
    // 邻接表
    int[][] graph;
    // 当前递归路径
    List<Integer> curList = new ArrayList<>();
    // 图的长度
    int n;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        curList.add(0);
        n = graph.length;
        dfs(0);
        return ans;
    }

    public void dfs(int x) {
        if (x == n - 1) {
            ans.add(new ArrayList<>(curList));
            return;
        }
        for (int neighbor : graph[x]) {
            curList.add(neighbor);
            dfs(neighbor);
            // 递归返回时，将当前节点从curList中删除
            curList.remove(curList.size() - 1);
        }
    }
}
