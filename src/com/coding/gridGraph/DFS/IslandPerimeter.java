package com.coding.gridGraph.DFS;

/**
 * 岛屿的周长
 * index:463
 * <a href="https://leetcode.cn/problems/island-perimeter/">...</a>
 */
public class IslandPerimeter {

    private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int islandPerimeter_dfs(int[][] grid) {
        // 题目说网格中恰好仅有一个岛屿，所以找到第一个1开始dfs即可
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    public int dfs(int[][] grid, int i, int j) {
        // 先进再判断, 如果当前元素是0或不在网格范围内，意味着上一个岛屿与海水相邻，该边需要被统计
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] == 2) {
            return 0;
        }
        int perimeter = 0;
        grid[i][j] = 2; // 标记为2，避免重复遍历
        for (int[] dir : DIRS) {
            int x = i + dir[0];
            int y = j + dir[1];
            perimeter += dfs(grid, x, y);
        }
        return perimeter;
    }

    public int islandPerimeter_no_dfs(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                for (int[] dir : DIRS) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x < 0 || x == grid.length || y < 0 || y == grid[0].length || grid[x][y] == 0) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

}
