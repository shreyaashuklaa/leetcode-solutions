// import java.util.*;

// class Solution {
//     public int[][] merge(int[][] intervals) {

//         Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

//         List<int[]> ans = new ArrayList<>();

//         for (int i = 0; i < intervals.length; i++) {

//             if (ans.isEmpty() || intervals[i][0] > ans.get(ans.size() - 1)[1]) {
//                 ans.add(new int[]{intervals[i][0], intervals[i][1]});
//             } else {
//                 ans.get(ans.size() - 1)[1] =Math.max(ans.get(ans.size() - 1)[1], intervals[i][1]);
//             }
//         }

//         return ans.toArray(new int[ans.size()][]);
//     }
// }


class Solution {
    public int[][] merge(int[][] intervals) {

        // Sort intervals based on starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();

        // First interval becomes current interval
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            // Overlapping interval
            if (intervals[i][0] <= end) {

                // Extend the current interval
                end = Math.max(end, intervals[i][1]);
            }
            else {

                // No overlap, store current interval
                result.add(new int[]{start, end});

                // Start a new interval
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        // Add the last interval
        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }
}