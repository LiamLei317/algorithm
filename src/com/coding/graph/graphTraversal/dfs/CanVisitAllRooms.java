package com.coding.graph.graphTraversal.dfs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 钥匙和房间
 * index:841
 * <a href="https://leetcode.cn/problems/keys-and-rooms/">...</a>
 */
public class CanVisitAllRooms {

    private List<List<Integer>> rooms;
    private Set<Integer> visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        this.rooms = rooms;
        this.visited = new HashSet<>();
        visited.add(0);
        dfs(0);
        return visited.size() == rooms.size();
    }

    private void dfs(int index) {
        for (int next : rooms.get(index)) {
            if (!visited.contains(next)) {
                visited.add(next);
                dfs(next);
            }
        }
    }
}
