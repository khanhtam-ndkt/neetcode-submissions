class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] s1 = str.toCharArray();
            Arrays.sort(s1);
            String ss = new String(s1);
            if (!map.containsKey(ss)) {
                map.put(ss, new ArrayList<>());
            }
            map.get(ss).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
