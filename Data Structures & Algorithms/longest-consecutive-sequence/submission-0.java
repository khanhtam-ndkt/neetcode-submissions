class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int count = 0;
                while (set.contains(i)) {
                    count++;
                    i++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
