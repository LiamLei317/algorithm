package com.coding.gridGraph.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class HighestPeak {
    private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length, m = isWater[0].length;
        // 答案矩阵
        int[][] ans = new int[n][m];
        // 多源队列
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        // 遍历队列
        int hight = 0;
        while (!queue.isEmpty()) {
            hight++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : DIRS) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x >= 0 && x < n && y >= 0 && y < m && isWater[x][y] == 0) {
                        ans[x][y] = hight;
                        isWater[x][y] = 1;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
        return ans;
    }
}
