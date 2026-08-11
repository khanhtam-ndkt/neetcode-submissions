class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int res = 0;
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            if (map.containsKey(arr[right])) {
                left = Math.max(left, map.get(arr[right]) + 1);
            }
            map.put(arr[right], right);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}