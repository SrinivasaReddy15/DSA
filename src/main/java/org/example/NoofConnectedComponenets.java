package org.example;

import java.util.ArrayList;
import java.util.List;

public class NoofConnectedComponenets {


    public int countComponents(int n, int[][] edges) {

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u); // because undirected
        }

        // Step 2: Visited array
        boolean[] visited = new boolean[n];
        int components = 0;

        // Step 3: DFS from every unvisited node
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i);
                components++; // finished exploring one whole group
            }
        }

        return components;
    }

    // Standard DFS
    private void dfs(List<Integer>[] graph, boolean[] visited, int node) {
        visited[node] = true;
        for (int nei : graph[node]) {
            if (!visited[nei]) {
                dfs(graph, visited, nei);
            }
        }
    }



    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                {0,1},
                {1,2},
                {3,4}
        };

        NoofConnectedComponenets obj = new NoofConnectedComponenets();
        int result = obj.countComponents(n, edges);

        System.out.println("Number of connected components = " + result);
    }


}
