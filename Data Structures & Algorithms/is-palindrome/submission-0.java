class Solution {
    public boolean isPalindrome(String s) {
        char[] s1 = s.toCharArray();
        int left = 0;
        int right = s1.length - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(s1[left])) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s1[right])) {
                right--;
                continue;
            }
            if (Character.toLowerCase(s1[left]) != Character.toLowerCase(s1[right]))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
