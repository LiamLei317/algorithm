package com.coding.gridGraph.DFS;

/**
 * 总价值可以被K整除的岛屿数目
 * index:3619
 * <a href="https://leetcode.cn/problems/count-islands-with-total-value-divisible-by-k/">...</a>
 */
public class CountIslands {

    // 方向数组
    private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int countIslands(int[][] grid, int k) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0 && dfs(grid, i, j) % k == 0) {
                   ans++;
                }
            }
        }
        return ans;
    }

    public long dfs(int[][] grid, int i, int j) {
        long kSum = grid[i][j]; // 岛屿的k值之和
        grid[i][j] = -1; // 标记当前已经算过
        // 遍历方向数组，向四个方向扩散
        for (int[] dir : DIRS) {
            int x = i + dir[0];
            int y = j + dir[1];
            // 先判断再进栈，避免无谓的消耗
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] > 0) {
                kSum += dfs(grid, x, y);
            }
        }
        return kSum;
    }
}
