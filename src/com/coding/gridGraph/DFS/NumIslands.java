package com.coding.gridGraph.DFS;

/**
 * 岛屿数量
 * index:200
 * <a href="https://leetcode.cn/problems/number-of-islands/">...</a>
 */
public class NumIslands {

    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     *  dfs 实现算法，把是 1 的都置为 2
     */
    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2'; // 如果是倒闭就置为 2，避免死循环
        dfs(grid, i, j + 1); // 上
        dfs(grid, i, j - 1); // 下
        dfs(grid, i - 1, j); // 左
        dfs(grid, i + 1, j); // 右
    }
}
