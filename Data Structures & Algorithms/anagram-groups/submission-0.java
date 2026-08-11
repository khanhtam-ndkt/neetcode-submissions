class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] s1 = str.toCharArray();
            Arrays.sort(s1);
            StringBuilder sb = new StringBuilder();
            for (char c : s1) {
                sb.append(c);
            }
            if (!map.containsKey(sb.toString())) {
                map.put(sb.toString(), new ArrayList<>());
            }
            map.get(sb.toString()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
