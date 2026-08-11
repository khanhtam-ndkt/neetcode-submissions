class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Arrays.sort(nums);
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        int[] f = new int[freq.size()];
        int id = 0;
        for (int fq : freq.values()) {
            f[id++] = fq;
        }
        Arrays.sort(f);
        id = f.length - 1;
        int count = 0;
        for (int i = 1; i <= k; i++) {
            for (int key : freq.keySet()) {
                if (freq.get(key) == f[id]) {
                    res[count++] = key;
                    id--;
                    freq.remove(key);
                    break;
                }
            }
        }
        return res;
    }
}
