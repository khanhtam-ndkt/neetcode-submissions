class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length == 1) return false;
        // if (nums.length == 2) return nums[0] == nums[1];
        Arrays.sort(nums);
        int maxsum = 0;
        for (int i : nums) {
            maxsum += i;
        }
        if (maxsum % 2 != 0) return false;
        maxsum /= 2;
        // List<Integer> sum = new ArrayList<>();
        boolean[] sum = new boolean[maxsum + 1]; //track existence
        sum[0] = true;
        for (int i = 0; i < nums.length; i++) {
            System.out.println("> i: " + i + ", nums[i]: " + nums[i]);
            System.out.println(maxsum - nums[i]);
            if (maxsum - nums[i] >= 0 && sum[maxsum - nums[i]] == true) return true;
            for (int id = sum.length - 1; id >= 0; id--) {
                if (sum[id] == true && nums[i] + id < maxsum) {
                    sum[nums[i] + id] = true;
                }
            }
        }
        return false;
    }
}

/*

        2   3   4   8   9   14
        
        2                       ->  2
            3                   ->  3   5
                4               ->  4   6   7   9
                    8           ->  
*/