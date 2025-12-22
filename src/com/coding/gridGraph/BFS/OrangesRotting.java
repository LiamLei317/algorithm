package com.coding.gridGraph.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 腐烂的橘子
 * index:994
 * <a href="https://leetcode.cn/problems/rotting-oranges/">...</a>
 */
public class OrangesRotting {
    private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCnt = 0;
        // 把所有的 2 放入队列,并统计新鲜橘子的数量
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCnt++;
                }
            }
        }
        // 边界 case 处理
        if (freshCnt == 0) {
            return 0;
        }
        // 开始遍历
        int minutes = -1;
        while (!queue.isEmpty()) {
            minutes++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : DIRS) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x < 0 || x >= n || y < 0 || y >= m) {
                        continue;
                    }
                    // 感染新鲜橘子，并入队
                    if (grid[x][y] == 1) {
                        grid[x][y] = 2;
                        freshCnt--;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
        return freshCnt == 0 ? minutes : -1;
    }
}
