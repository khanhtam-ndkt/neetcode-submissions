class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num = (nums1.length + nums2.length - 1) / 2 + 1;
        int res = 0;
        int[] find = new int[2];
        if ((nums1.length + nums2.length) % 2 != 0) {
            find[0] = num;
            find[1] = num;
        }
        else {
            find[0] = num;
            find[1] = num + 1;
        }
        int count = 0;
        int l1 = 0; int l2 = 0;
        while (count <= find[1]) {
            System.out.println(count);
            if (l2 < nums2.length
            && (l1 == nums1.length || nums2[l2] <= nums1[l1])) {
                count++;
                if (find[0] == count) res += nums2[l2];
                if (find[1] == count) {
                    res += nums2[l2];
                    break;
                }
                l2++;
            }
            else if (l1 < nums1.length
            && (l2 == nums2.length || nums2[l2] > nums1[l1])) {
                count++;
                if (find[0] == count) res += nums1[l1];
                if (find[1] == count) {
                    res += nums1[l1];
                    break;
                }
                l1++;
            }
        }
        return (double) res / 2;
    }
}
