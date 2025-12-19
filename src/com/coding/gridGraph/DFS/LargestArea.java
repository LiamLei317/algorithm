package com.coding.gridGraph.DFS;

/**
 * 主题空间
 * index:LCS 03
 * <a href="https://leetcode.cn/problems/YesdPw/">...</a>
 */
public class LargestArea {

    private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private boolean flag = true; // 当前递归的区域是否是合法区域
    private char[][] map;

    public int largestArea(String[] grid) {
        int rows = grid.length;
        int cols = grid[0].length();
        // 把一维字符串数组变成二维整数数组
        map = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            map[i] = grid[i].toCharArray();
        }
        int ans = 0;
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (map[i][j] > '0') { // 大于 0 的才有必要计算
                    // 找到面积最大的
                    flag = true;
                    int area = dfs(i, j, map[i][j]);
                    if (flag) {
                        ans = Math.max(ans, area);
                    }
                }
            }
        }
        return ans;
    }

    public int dfs(int i, int j, char pre) {
        // 超出边界或者当前是 0 都意味着这个空间和走廊相邻，需要把 flag 置为 false
        if (i < 0 || i >= map.length || j < 0 || j >= map[0].length || map[i][j] == '0') {
            flag = false;
            return 0;
        }
        // 当前元素如果是 -1 或者 当前元素和上一个元素不同，则返回 0，但是不需要修改 flag
        if (map[i][j] == 'x' || map[i][j] != pre) {
            return 0;
        }
        int area = 1;
        map[i][j] = 'x'; // 当前值置为 x，避免重复遍历
        for (int[] dir : DIRS) {
            int x = i + dir[0];
            int y = j + dir[1];
            area += dfs(x, y, pre);
        }
        return area;
    }
}
