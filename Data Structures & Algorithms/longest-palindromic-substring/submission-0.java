class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        int maxlen = 1;
        int[] pos = new int[]{0, 0};
        char[] s1 = s.toCharArray();
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s1.length; i++) {
            if (!map.containsKey(s1[i])) {
                map.put(s1[i], new ArrayList<>());
            }
            map.get(s1[i]).add(i);
        }
        for (List<Integer> id : map.values()) {
            if (id.size() < 2) continue;
            for (int i = 0; i < id.size(); i++) {
                int leftIdx = id.get(i);
                for (int j = i + 1; j < id.size(); j++) {
                    int rightIdx = id.get(j);
                    int currentLen = rightIdx - leftIdx + 1;
                    if (currentLen > maxlen
                    && isPalindrome(s1, leftIdx, rightIdx)) {
                        maxlen = currentLen;
                        pos[0] = leftIdx;
                        pos[1] = rightIdx;
                    }
                }
            }
        }
        return s.substring(pos[0], pos[1] + 1);
    }

    public boolean isPalindrome(char[] s1, int start, int end) {
        int left = start;
        int right = end;
        while (left <= right) {
            if (s1[left] != s1[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
