class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                if (!set.add(board[i][j])) {
                    System.out.println("Here1: " + board[i][j]);
                    return false;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') continue;
                if (!set.add(board[j][i])) {
                    System.out.println("Here2: " + board[j][i]);
                    return false;
                }
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Set<Character> set = new HashSet<>();
                if ((board[i][j] != '.' && !set.add(board[i][j]))
                || (board[i + 1][j] != '.' &&!set.add(board[i + 1][j]))
                || (board[i + 2][j] != '.' &&!set.add(board[i + 2][j]))
                || (board[i][j + 1] != '.' &&!set.add(board[i][j + 1]))
                || (board[i + 1][j + 1] != '.' &&!set.add(board[i + 1][j + 1]))
                || (board[i + 2][j + 1] != '.' &&!set.add(board[i + 2][j + 1]))
                || (board[i][j + 2] != '.' &&!set.add(board[i][j + 2]))
                || (board[i + 1][j + 2] != '.' &&!set.add(board[i + 1][j + 2]))
                || (board[i + 2][j + 2] != '.' &&!set.add(board[i + 2][j + 2]))) {
                    System.out.println("Here3");
                    return false;
                }
            }
        }
        return true;
    }
}
