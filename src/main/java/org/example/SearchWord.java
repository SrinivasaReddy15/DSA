package org.example;

public class SearchWord {

        public boolean exist(char[][] board, String word) {
            int m = board.length;
            if (m == 0) return false;
            int n = board[0].length;

            // If word is longer than total cells, impossible
            if (word.length() > m * n) return false;

            boolean[][] visited = new boolean[m][n];

            // Try starting DFS from every cell
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(board, word, 0, i, j, visited)) {
                        return true;
                    }
                }
            }

            return false;
        }

        private boolean dfs(char[][] board, String word, int idx,
                            int r, int c, boolean[][] visited) {

            // If full word matched
            if (idx == word.length()) return true;

            // Boundary check or mismatch or already used cell
            if (r < 0 || c < 0 || r >= board.length || c >= board[0].length ||
                    board[r][c] != word.charAt(idx) || visited[r][c]) {
                return false;
            }

            // Mark visited
            visited[r][c] = true;

            // Explore 4 possible directions
            boolean found = dfs(board, word, idx + 1, r + 1, c, visited) ||
                    dfs(board, word, idx + 1, r - 1, c, visited) ||
                    dfs(board, word, idx + 1, r, c + 1, visited) ||
                    dfs(board, word, idx + 1, r, c - 1, visited);

            // Backtrack → unmark visited
            visited[r][c] = false;

            return found;
        }
    }

