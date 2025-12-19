package com.coding.gridGraph.BFS;

import java.util.ArrayList;
import java.util.List;

/**
 * 二进制矩阵中的最短路径
 * index:1091
 * <a href="https://leetcode.cn/problems/shortest-path-in-binary-matrix/">...</a>
 */
public class ShortestPathBinaryMatrix {

    private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        int n = grid.length, m = grid[0].length;
        if ((n == 1 && m == 1 && grid[0][0] == 0)) {
            return 1;
        }
        List<int[]> queue = List.of(new int[]{0, 0});
        grid[0][0] = 1; // 置为1，代表已访问
        for (int ans = 1; !queue.isEmpty(); ans++) {
            List<int[]> temp = queue;
            queue = new ArrayList<>();
            for (int[] cur : temp) {
                for (int[] dir : DIRS) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x == n - 1 && y == m - 1 && grid[x][y] == 0) {
                        // 遍历到左下角就终止循环
                        return ++ans;
                    }
                    if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 0) {
                        queue.add(new int[]{x, y});
                        grid[x][y] = 1;
                    }
                }
            }
        }
        return -1;
    }
}
