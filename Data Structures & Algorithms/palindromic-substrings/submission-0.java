class Solution {
    public int countSubstrings(String s) {
        if (s.length() == 1) return 1;
        char[] s1 = s.toCharArray();
        boolean[][] dp = new boolean[s1.length][s1.length];
        
        int count = 0;
        for (int len = 1; len <= s1.length; len++) {
            for (int i = 0; i <= s1.length - len; i++) {
                int j = i + len - 1;
                if (s1[i] == s1[j]) {
                    if (len <= 2 || dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
