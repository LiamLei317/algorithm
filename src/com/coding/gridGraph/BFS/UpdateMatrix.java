package com.coding.gridGraph.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 01矩阵
 * index:542
 * <a href="https://leetcode.cn/problems/01-matrix/">...</a>
 */
public class UpdateMatrix {
    private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        // 做 一个 visit 数组
        int[][] visit = new int[n][m];
        // 所有的 0 入列
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] { i, j });
                    visit[i][j] = 1;
                }
            }
        }
        // 遍历队列
        int ans = 0;
        while (!queue.isEmpty()) {
            ans++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : DIRS) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x >= 0 && x < n && y >= 0 && y < m && mat[x][y] == 1 && visit[x][y] == 0) {
                        mat[x][y] = ans; // 把数组改成当前轮数
                        queue.offer(new int[] { x, y });
                        visit[x][y] = 1;
                    }
                }
            }
        }
        return mat;
    }
}
