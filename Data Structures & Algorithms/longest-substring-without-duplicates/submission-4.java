class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        int res = 1;
        Set<Character> set = new HashSet<>();
        char[] arr = s.toCharArray();
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            while (!set.isEmpty() && set.contains(arr[right])) {
                set.remove(arr[left]);
                left++;
            }
            set.add(arr[right]);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
