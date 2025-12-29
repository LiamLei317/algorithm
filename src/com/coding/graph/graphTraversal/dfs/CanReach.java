package com.coding.graph.graphTraversal.dfs;

/**
 * 跳跃游戏 II
 * index:1306
 * <a href="https://leetcode.cn/problems/jump-game-iii/">...</a>
 */
public class CanReach {

    private int n;
    private boolean[] visited;
    private int[] arr;

    public boolean canReach(int[] arr, int start) {
        this.n = arr.length;
        this.visited = new boolean[n];
        this.arr = arr;
        visited[start] = true;
        return dfs(start);
    }

    public boolean dfs(int index) {
        if (arr[index] == 0) {
             return true;
        }
        boolean res = false;
        int next = index + arr[index];
        if (next < n && !visited[next]) {
            visited[index + arr[index]] = true;
            res |= dfs(index + arr[index]);
        }
        next = index - arr[index];
        if (next >= 0 && !visited[next]) {
            visited[index - arr[index]] = true;
            res |= dfs(index - arr[index]);
        }
        return res;
    }
}
