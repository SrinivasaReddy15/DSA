package org.example;

import java.util.ArrayList;
import java.util.List;

public class DetectCycle {
        public boolean hasCycle(int n, int[][] edges) {

            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

            for (int[] e : edges) {
                graph.get(e[0]).add(e[1]);
            }

            boolean[] visited = new boolean[n];
            boolean[] inStack = new boolean[n];


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
            inStack[node] = true;

            for (int nei : graph.get(node)) {

                if (!visited[nei]) {
                    if (dfs(graph, nei, visited, inStack)) {
                        return true;
                    }
                }

                else if (inStack[nei]) {
                    return true;
                }
            }

            inStack[node] = false;
            return false;
        }
    }

