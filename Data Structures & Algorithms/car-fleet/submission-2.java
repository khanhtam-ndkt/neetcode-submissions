class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pos = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pos[i][0] = position[i];
            pos[i][1] = speed[i];
        }
        Arrays.sort(pos, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(b[1], a[1]);
            return Integer.compare(b[0], a[0]);
        });
        Deque<Double> time = new ArrayDeque<>();
        for (int p[] : pos) {
            double t = (double) (target - p[0]) / p[1];
            if (time.isEmpty() || t > time.peek()) {
                time.push(t);
            }
        }
        return time.size();
    }
}

/*
    0,1     1,2     4,2     7,1     target 10
    10      4.5     3       3

    1,3     4,2     target 10
    3       3


*/