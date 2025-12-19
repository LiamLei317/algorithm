package com.coding.gridGraph.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * 水域大小
 * index:面试题 16.19
 * <a href="https://leetcode.cn/problems/pond-sizes-lcci/">...</a>
 */
public class PondSizes {

    // 八个方向的方向矩阵
    private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public int[] pondSizes(int[][] land) {
        int n = land.length, m = land[0].length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 0) {
                    list.add(dfs(land, i, j));
                }
            }
        }
        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    public int dfs(int[][] land, int i, int j) {
        land[i][j] = 1; // 标记为1，避免重复遍历
        int area = 1;
        // 遍历 8 个方向
        for (int[] dir : DIRS) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < land.length && y >= 0 && y < land[0].length && land[x][y] == 0) {
                area += dfs(land, x, y);
            }
        }
        return area;
    }
}
