class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int least = 1;
        int most = piles[piles.length - 1];
        int res = most;
        while (least <= most) {
            int mid = least + (most - least) / 2;
            int count = 0;
            for (int i = piles.length - 1; i >= 0; i--) {
                count += piles[i] / mid;
                if (piles[i] % mid != 0) {
                    count++;
                }
                if (count > h) break;
            }
            if (count <= h) {
                res = Math.min(res, mid);
                most = mid - 1;
            }
            else {
                least = mid + 1;
            }
            
        }
        return res;
    }
}

//  3   6   7   11
// most = 11
// least = 1
// mid = 6
// count mid = 2 + 2 + 1 + 1 = 6
//