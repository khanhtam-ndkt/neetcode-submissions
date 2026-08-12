class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int[] freq1 = new int[26];
        for (char c : c1) {
            freq1[c - 'a']++;
        }
        for (int i = 0; i < (c2.length - c1.length + 1); i++) {
            if (freq1[c2[i] - 'a'] > 0) {
                int[] freq2 = freq1.clone();
                boolean zero = true;
                for (int j = i; j < i + c1.length; j++) {
                    freq2[c2[j] - 'a']--;
                }
                for (int j : freq2) {
                    if (j != 0) zero = false;
                }
                if (zero == true) return true;
            }
        }
        return false;
    }
}

// 7 - 3 + 1
//  l e c a b e e
//  0 1 2 3 4 5 6