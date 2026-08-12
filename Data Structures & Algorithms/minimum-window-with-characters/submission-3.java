class Solution {
    public String minWindow(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        Set<Character> set = new HashSet<>();
        int[] freq = new int[128];

        for (char c : t1) {
            set.add(c);
            freq[c]++;
        }

        int min = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;

        int left = 0;

        for (int i = 0; i < s1.length; i++) {
            if (set.contains(s1[i])) {
                left = i;
                break;
            }
        }

        for (int right = left; right < s1.length; right++) {

            // Add right character to window
            if (set.contains(s1[right])) {
                freq[s1[right]]--;
            }

            // Check if window is valid
            boolean valid = true;

            for (char c : set) {
                if (freq[c] > 0) {
                    valid = false;
                    break;
                }
            }

            // Try shrinking while window is valid
            while (valid && left <= right) {

                // Save current valid window
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    start = left;
                    end = right;
                }

                // Remove left character
                if (set.contains(s1[left])) {
                    freq[s1[left]]++;
                }

                left++;

                // Check if window is still valid
                valid = true;

                for (char c : set) {
                    if (freq[c] > 0) {
                        valid = false;
                        break;
                    }
                }
            }
        }

        if (start == -1) return "";

        return s.substring(start, end + 1);
    }
}