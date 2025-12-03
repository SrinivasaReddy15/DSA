package org.example;

public class SearchWord {

        public boolean exist(char[][] board, String word) {
            int m = board.length;
            if (m == 0) return false;
            int n = board[0].length;


            if (word.length() > m * n) return false;

            boolean[][] visited = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dfs(board, word, 0, i, j, visited)) {
                        return true;
                    }
                }
            }

            return false;
        }

        private boolean dfs(char[][] board, String word, int idx,int r, int c, boolean[][] visited)
        {

            if (idx == word.length()) return true;


            if (r < 0 || c < 0 || r >= board.length || c >= board[0].length ||
                    board[r][c] != word.charAt(idx) || visited[r][c]) {
                return false;
            }

            visited[r][c] = true;

            boolean found = dfs(board, word, idx + 1, r + 1, c, visited) ||
                    dfs(board, word, idx + 1, r - 1, c, visited) ||
                    dfs(board, word, idx + 1, r, c + 1, visited) ||
                    dfs(board, word, idx + 1, r, c - 1, visited);

            visited[r][c] = false;

            return found;
        }
    }

