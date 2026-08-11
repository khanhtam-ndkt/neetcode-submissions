class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        int[] freq = new int[26];
        for (int i = 0; i < s1.length; i++) {
            freq[s1[i] - 'a']++;
            freq[t1[i] - 'a']--;
        }
        for (int i : freq) {
            if (i != 0) return false;
        }
        return true;
    }
}
