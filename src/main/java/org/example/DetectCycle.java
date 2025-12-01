package org.example;

import java.util.ArrayList;
import java.util.List;

public class DetectCycle {
        public boolean hasCycle(int n, int[][] edges) {
            // Build adjacency list
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

            for (int[] e : edges) {
                graph.get(e[0]).add(e[1]);   // directed edge
            }

            boolean[] visited = new boolean[n];
            boolean[] inStack = new boolean[n];

            // Check each component
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    if (dfs(graph, i, visited, inStack)) {
                        return true; // cycle found
                    }
                }
            }

            return false;
        }

        private boolean dfs(List<List<Integer>> graph, int node,
                            boolean[] visited, boolean[] inStack) {

            visited[node] = true;
            inStack[node] = true;  // this node is now in recursion stack

            for (int nei : graph.get(node)) {
                // Case 1: Not visited → DFS on it
                if (!visited[nei]) {
                    if (dfs(graph, nei, visited, inStack)) {
                        return true;
                    }
                }
                // Case 2: If neighbor is in current path → cycle
                else if (inStack[nei]) {
                    return true;
                }
            }

            inStack[node] = false; // leaving recursion path
            return false;
        }
    }

