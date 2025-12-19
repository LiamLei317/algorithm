package com.coding.gridGraph.BFS;

import java.util.ArrayList;
import java.util.List;

/**
 * 地图分析
 * index:1162
 * <a href="https://leetcode.cn/problems/as-far-from-land-as-possible/">...</a>
 */
public class MaxDistance {
    private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int maxDistance(int[][] grid) {

    }


    public int maxDistance_single(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 遍历数组中所有的 0
                if (grid[i][j] == 0) {
                    boolean[][] visited = new boolean[n][m];
                    List<int[]> queue = List.of(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        List<int[]> temp = queue;
                        queue = new ArrayList<>();
                        int curDist = -1;
                        for (int[] cur : temp) {
                            for (int[] dir : DIRS) {
                                int x = cur[0] + dir[0];
                                int y = cur[1] + dir[1];
                                if (x >= 0 && x < n && y >= 0 && y < m && !visited[x][y]) {
                                    queue.add(new int[]{x, y});
                                    visited[x][y] = true;
                                    if (grid[x][y] == 1) {
                                        int dist = Math.abs(x - i) + Math.abs(y - j);
                                        curDist = Math.max(curDist, dist);
                                    }
                                }
                            }
                        }
                        // 本轮循环中如果找到了 1，那就把本轮找到的最大距离和 ans 对比更新并清空 list
                        if (curDist > -1) {
                            ans = Math.max(ans, curDist);
                            queue = new ArrayList<>();
                        }
                    }
                }
            }
        }
        return ans;
    }
}
