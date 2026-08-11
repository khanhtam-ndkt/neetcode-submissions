class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = count;
            count *= nums[i];
        }
        count = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= count;
            count *= nums[i];
        }
        return res;
    }
}  


//      1       2       4       6
//      1       1       1*2     1*2*4
//      2*4*6   4*6     6       1