class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        char[] s1 = s.toCharArray();
        for (char c : s1) {
            if (c == ')') {
                if (st.isEmpty() || st.pop() != '(') return false;
            }
            else if (c == '}') {
                if (st.isEmpty() || st.pop() != '{') return false;
            }
            else if (c == ']') {
                if (st.isEmpty() || st.pop() != '[') return false;
            }
            else st.push(c);
        }
        return st.isEmpty();
    }
}
