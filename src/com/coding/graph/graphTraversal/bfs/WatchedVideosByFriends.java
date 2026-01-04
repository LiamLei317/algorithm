package com.coding.graph.graphTraversal.bfs;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 获取你好友已观看的视频
 * index:1311
 * <a href="https://leetcode.cn/problems/get-watched-videos-by-your-friends/">...</a>
 */
public class WatchedVideosByFriends {

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        // 通过 bfs 找人
        List<Integer> friendsList = bfs(friends, id, level);
        // 获取所有已观看的视频
        Map<String, Integer> freqMap = new HashMap<>();
        for (int friendId : friendsList) {
            for (String video : watchedVideos.get(friendId)) {
                freqMap.put(video, freqMap.getOrDefault(video, 0) + 1);
            }
        }
        // 排序
        List<String> res = new ArrayList<>(freqMap.keySet());
        res.sort((a, b) -> {
            int freqA = freqMap.get(a);
            int freqB = freqMap.get(b);
            // 频次不同按频次升序
            if (freqA != freqB) {
                return freqA - freqB;
            }
            // 频次相同按字典序升序
            return a.compareTo(b);
        });
        return res;
    }

    private List<Integer> bfs(int[][] friends, int id, int level) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(id);
        boolean[] vis = new boolean[friends.length];
        vis[id] = true;
        int curLevel = 0;
        while (!q.isEmpty()) {
            if (curLevel == level) {
                return new ArrayList<>(q);
            }
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                for (int next : friends[cur]) {
                    if (!vis[next]) {
                        vis[next] = true;
                        q.offer(next);
                    }
                }
            }
            curLevel++;
        }
        return new ArrayList<>();
    }
}
