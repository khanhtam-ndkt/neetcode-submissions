class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        char[] s1 = s.toCharArray();
        int count = 0;
        int[][] pos = new int[26][2];
        for (int i = 0; i < 26; i++) {
            pos[i][0] = -1;
            pos[i][1] = -1;
        }
        for (int i = 0; i < s1.length; i++) {
            if (pos[s1[i] - 'a'][0] == -1) {
                pos[s1[i] - 'a'][0] = i;
                count++;
            }
            pos[s1[i] - 'a'][1] = i;
        }
        int[][] pos1 = new int[count][2];
        int id = 0;
        for (int[] p : pos) {
            if (p[0] != -1) {
                pos1[id][0] = p[0];
                pos1[id][1] = p[1];
                // System.out.println(pos1[id][0]);
                id++;
            }
        }
        Arrays.sort(pos1, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < pos1.length; i++) {
            // System.out.println(pos1[i][0]);
            if (pos1[i][0] == -1) continue;
            // System.out.println("prev left: " + pos1[i][0] + ", right: " + pos1[i][1]);
            for (int j = i + 1; j < pos1.length; j++) {
                if (pos1[j][0] < pos1[i][1]) {
                    pos1[i][1] = Math.max(pos1[i][1], pos1[j][1]);
                    // System.out.println("changed right: " + pos1[i][1]);
                    pos1[j][0] = -1;
                    pos1[j][1] = -1;
                }
            }
            // System.out.println("new left: " + pos1[i][0] + ", right: " + pos1[i][1]);
            res.add(pos1[i][1] - pos1[i][0] + 1);
        }
        // for (int p[] : pos1) {
        //     System.out.println(p[0] + " " + p[1]);
        // }
        return res;
    }
}

/*
    0   1   2   3   4   5   6   7   8   9   10  11  12
    x   y   x   x   y   z   b   z   b   b   i   s   l


    x y z b i s l

*/