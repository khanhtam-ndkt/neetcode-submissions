class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        char[] s1 = s.toCharArray();
        boolean[][] dp = new boolean[s1.length][s1.length];
        
        int start = 0;
        int maxlen = 1;
        
        for (int len = 1; len <= s1.length; len++) {
            for (int i = 0; i <= s1.length - len; i++) {
                int j = i + len - 1;
                if (s1[i] == s1[j]) {
                    if (len <= 2 || dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;
                        if (len > maxlen) {
                            maxlen = len;
                            start = i;
                        }
                    }
                }
            }
        }
        return s.substring(start, start + maxlen);
    }
}

/*

    a   b   a   b   d
    ab  ba  ab  bd      
    aba

*/