package com.coding.gridGraph.BFS;

import java.util.ArrayList;
import java.util.List;

/**
 * 迷宫中离入口最近的出口
 * index:1926
 * <a href="https://leetcode.cn/problems/nearest-exit-from-entrance-in-maze/">...</a>
 */
public class NearestExit {

    private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length, m = maze[0].length;
        // 用一个二维数组表示是否访问过
        boolean[][] visited = new boolean[n][m];
        // 当前元素设为已访问
        visited[entrance[0]][entrance[1]] = true;
        // bfs 专用队列
        List<int[]> queue = List.of(entrance);
        // 开始 bfs 搜索,每搜索一次，意味着往外扩了一层
        for (int ans = 1; !queue.isEmpty(); ans++) {
            // 拿出 queue 的所有元素
            List<int[]> temp = queue;
            // 清空 queue，代表下次循环是下一层了
            queue = new ArrayList<>();
            // 开始遍历这一层
            for (int[] cur : temp) {
                for (int[] dir : DIRS) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    // 先判断当前元素是否符合条件: 在边界内，且未被访问过，且是 .
                    if (x >= 0 && x < n && y >= 0 && y < m && maze[x][y] == '.' && !visited[x][y]) {
                        // 如果当前元素在边界直接返回结果，也就是层数
                        if (x == 0 || x == n - 1 || y == 0 || y == m - 1) {
                            return ans;
                        }
                        // 否则加到bfs队列
                        queue.add(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
        }
        return -1;
    }
}
