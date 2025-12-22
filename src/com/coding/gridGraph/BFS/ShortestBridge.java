package com.coding.gridGraph.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 最短的桥
 * index:934
 * <a href="https://leetcode.cn/problems/shortest-bridge/">...</a>
 */
public class ShortestBridge {

    private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // 方向数组
    private int[][] visited; // 是否访问标记
    public int shortestBridge(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        visited = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        // 循环找到第一个1，并使用深度优先找到这个1所在岛屿的全部坐标并入队
        searchOneIslandLoop:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = 1;
                    queue.offer(new int[]{i, j});
                    dfs_findOneIsland(queue, grid, i, j);
                    break searchOneIslandLoop;
                }
            }
        }
        // 接下来bfs的时候也需要一个visited数组，可以复用刚刚的，但是要处理一下，只有在队列中的元素才是1
        // 但是直接处理队列很麻烦，所以通过刚刚dfs 的时候的visited数组和 grid 比对，都是1的元素才认为在队列中
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = visited[i][j] & grid[i][j]; // 都是1的元素才认为在队列中
            }
        }
        int ans = -1;
        while (!queue.isEmpty()) {
            ans++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                visited[cur[0]][cur[1]] = 1;
                for (int[] dir : DIRS) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x < 0 || x >= n || y < 0 || y >= m) {
                        continue;
                    }
                    // 找到了一个没访问过的1，直接返回答案
                    if (grid[x][y] == 1 && visited[x][y] == 0) {
                        return ans;
                    }
                    if (grid[x][y] == 0) {
                        grid[x][y] = 1;
                        visited[x][y] = 1;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
        return -1;
    }

    /**
     * 找到给定 i j 的所有的相邻的 1并入队
     */
    public void dfs_findOneIsland(Queue<int[]> queue, int[][] grid, int i, int j) {
        int n = grid.length, m = grid[0].length;
        for (int[] dir : DIRS) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 1 && visited[x][y] == 0) {
                visited[x][y] = 1; // 标记为已访问
                queue.offer(new int[]{x, y}); // 入队
                dfs_findOneIsland(queue, grid, x, y); // 递归
            }
        }
    }
}
