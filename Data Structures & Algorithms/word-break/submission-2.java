class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int max = 0; int min = 21;
        for (String ss : wordDict) {
            max = Math.max(max, ss.length());
            min = Math.min(min, ss.length());
        }
        // System.out.println("max: " + max + ", min: " + min);

        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            System.out.println("> i: " + i);
            if (i > 0 && dp[i - 1] != true) continue;
            for (int len = min; len <= max; len++) {
                int j = i + len - 1;
                System.out.println("j: " + j);
                if (j >= s.length()) break;
                System.out.println(s.substring(i, j + 1));
                if (wordSet.contains(s.substring(i, j + 1))) {
                    dp[j] = true;
                }
            }
        }
        return dp[dp.length - 1];
    }
}

/*

    a   p   p   l   e
    0   1   2   3   4
    len = 5, 
*/
