package com.coding.gridGraph.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 价格范围内最高排名的k样物体
 * index:2146
 * <a href="https://leetcode.cn/problems/k-highest-ranked-items-within-a-price-range/">...</a>
 */
public class HighestRankedKItems {

    private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        int n = grid.length, m = grid[0].length;
        // 已访问数组
        boolean[][] visited = new boolean[n][m];
        // bfs 队列
        List<int[]> queue = new ArrayList<>();
        // 起点入队
        queue.add(new int[] { start[0], start[1]});
        // 起点标记已访问
        visited[start[0]][start[1]] = true;
        // 答案列表
        List<List<Integer>> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            // 对列表中的元素排序
            queue.sort((a, b) -> {
                int pa = grid[a[0]][a[1]], pb = grid[b[0]][b[1]];
                return pa != pb ? pa - pb : a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
            });
            // 队列中的元素遍历处理
            for (int[] poll : queue) {
                // 已经按条件排序过了，满足条件的直接加到答案列表
                if (pricing[0] <= grid[poll[0]][poll[1]] && grid[poll[0]][poll[1]] <= pricing[1]) {
                    ans.add(List.of(poll[0], poll[1]));
                }
                if (ans.size() == k) {
                    return ans;
                }
            }
            List<int[]> temp = queue;
            queue = new ArrayList<>();
            for (int[] poll : temp) {
                for (int[] dir : DIRS) {
                    int x = poll[0] + dir[0];
                    int y = poll[1] + dir[1];
                    if (x >= 0 && x < n && y >= 0 && y < m && !visited[x][y] && grid[x][y] > 0) {
                        visited[x][y] = true;
                        queue.add(new int[] { x, y });
                    }
                }
            }
        }
        return ans;
    }
}
