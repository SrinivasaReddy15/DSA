package org.example;

import java.util.ArrayList;
import java.util.List;

public class PathExistsInGraph {
    public static boolean hasPath(int n, int[][] edges, int src, int dest) {


        if (n == 0) return false;
        if (src == dest) return true;


        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[n];
        return dfs(graph, src, dest, visited);
    }

    private static boolean dfs(List<List<Integer>> graph, int node, int dest, boolean[] visited) {
        if (node == dest) return true;

        visited[node] = true;

        for (int nei : graph.get(node)) {
            if (!visited[nei]) {
                if (dfs(graph, nei, dest, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,1},{0,2},{1,3},{3,4}};
        int src = 0, dest = 4;

        System.out.println(hasPath(n, edges, src, dest)); // true
    }
}

