class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        char[] arr = s.toCharArray();
        int[] freq = new int[26];
        int maxf = 0;
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            freq[arr[right] - 'A']++;
            maxf = Math.max(maxf, freq[arr[right] - 'A']);
            int windowlength = right - left + 1;
            if (windowlength - maxf > k) {
                freq[arr[left] - 'A']--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
