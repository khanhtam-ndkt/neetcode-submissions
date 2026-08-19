/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return true;
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        for (int i = 0; i < intervals.size(); i++) {
            for (int j = i + 1; j < intervals.size(); j++) {
                if (intervals.get(j).start >= intervals.get(i).end) {
                    break;
                }
                else return false;
            }
        }
        return true;
    }
}
