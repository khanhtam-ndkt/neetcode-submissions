class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String word : strs){
            sb.append(word.length());
            sb.append("#");
            sb.append(word);
        }
        System.out.println(sb);
        return sb.toString();
    }
    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            int start = j + 1;
            res.add(str.substring(start, start + len));
            i = start + len;
        }
        return res;
    }
}