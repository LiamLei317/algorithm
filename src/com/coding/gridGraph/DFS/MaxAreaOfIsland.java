package com.coding.gridGraph.DFS;

/**
 * 岛屿的最大面积
 * index:695
 * <a href="https://leetcode.cn/problems/max-area-of-island/">...</a>
 */
public class MaxAreaOfIsland {


    private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // 下右上左

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
        }
        return ans;
    }

    public int dfs(int[][] grid, int i, int j) {
        grid[i][j] = 2; // 当前标记为岛屿
        int area = 1; // 岛屿的面积
        // 遍历方向数组，向四个方向扩散
        for (int[] dir : DIRS) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                area += dfs(grid, x, y);
            }
        }
        return area;
    }


    /**
     * 我自己的写法
     */
    public int maxAreaOfIsland_my(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, dfs_my(grid, i, j));
                }
            }
        }
        return ans;
    }

    public int dfs_my(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2; // 如果是倒闭就置为 2，避免死循环
        int res = dfs_my(grid, i, j + 1); // 上
        res += dfs_my(grid, i, j - 1); // 下
        res += dfs_my(grid, i - 1, j); // 左
        res += dfs_my(grid, i + 1, j); // 右
        return res + 1; // 加上自己
    }
}
