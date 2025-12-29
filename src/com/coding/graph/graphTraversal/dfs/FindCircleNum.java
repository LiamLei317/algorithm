package com.coding.graph.graphTraversal.dfs;

/**
 * 省份数量
 * index:547
 * <a href="https://leetcode.cn/problems/number-of-provinces/">...</a>
 */
public class FindCircleNum {

    public int findCircleNum(int[][] isConnected) {
        // isConnected 数组的横向长度或者竖向长度就是城市数量
        int citiesNum = isConnected.length;
        // 标记当前城市有没有被访问过
        boolean[] visited = new boolean[citiesNum];
        int ans = 0;
        // 遍历每一个城市
        for (int i = 0; i < citiesNum; i++) {
            // 如果当前遍历的城市没有被访问过，则进行深度优先遍历
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                // 每次深度优先后，和当前遍历的城市联通或者间接联通的城市都被标记成已访问，所以省份数量可以自增
                ans++;
            }
        }
        return ans;
    }

    public void dfs(int[][] isConnected, boolean[] visited, int i) {
        // 遍历和当前深度优先节点相邻的节点
        for (int j = 0; j < isConnected.length; j++) {
            // i 和 j 联通且 j 没有被访问过
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, j);
            }
        }
    }
}
