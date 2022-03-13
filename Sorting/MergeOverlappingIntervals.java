import java.util.*;

public class MergeOverlappingIntervals {
    
    public static void main(String[] args) {
        // ArrayList<Interval> intervals = new ArrayList<>();

        // Interval i1 = new Interval(1,2);
        // Interval i2 = new Interval(3,5);
        // Interval i3 = new Interval(6,7);
        // Interval i4 = new Interval(8,10);
        // Interval i5 = new Interval(12,16);

        // intervals.add(i1);
        // intervals.add(i2);
        // intervals.add(i3);
        // intervals.add(i4);
        // intervals.add(i5);

        // insertAndMerge(intervals, new Interval(4,9));

        int intervals[][] = new int[][]{
            {1,5}, 
            {2,3},
            {4,6},
            {7,8},
            {8,16},
            {12,15}
        };


    }

    // GFG
    public static int[][] mergeIntervals(int intervals[][]) {
        List<int[]> al = new ArrayList<>();

        // Save the 1st interval to vars
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int currInterval[]: intervals) {

            // check if the current interval is overlapping or not
                // if overlapping then take the max (increase the size of the interval)
            if (currInterval[0] <= end) {
                end = Math.max(currInterval[1], end);
            } 
            
            // if not overlapping => means V have found an interval which is beyond the range of our stored interval so add our interval to the list and initialise the current interval values to our var so that V can compare them with with other intervals which are left
            else {
                al.add(new int[]{start, end});
                start = currInterval[0];
                end = currInterval[1];
            }

        }
        // at the end, last interval will be left from the loop, so add it to the last
        al.add(new int[]{start, end});

         // Convert the list to array
        return al.toArray(new int[0][]);
    }


    // Interview bit
    public static ArrayList<Interval> insertAndMerge(ArrayList<Interval> intervals, Interval newInterval) {

        for (Interval x: intervals) {
            System.out.println(x.start + " " + x.end);
        }

        if (intervals == null) {
            intervals = new ArrayList<>();
            intervals.add(newInterval);
            return intervals;
        }

        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }

        int i = 0;
        while (i < intervals.size()) {
            Interval currInterval = intervals.get(i);
            System.out.println("i: " + i);
            if (currInterval.end < newInterval.start) {
                i++;
                continue;
            } else if (newInterval.end < currInterval.start ) {
                System.out.println("New interval is " + newInterval.start + " " + newInterval.end +  " and  added at, i: " + i);
                intervals.add(i, newInterval);
                break;
            } else {
                newInterval.start = Math.min(currInterval.start, newInterval.start);
                newInterval.end = Math.max(currInterval.end, newInterval.end);
                intervals.remove(i);
            }
        }

        if (i == intervals.size()) {
            System.out.println("New interval is " + newInterval.start + " " + newInterval.end +  " and  added at the end: " + i);
            intervals.add(newInterval);
        }

        System.out.println("After inserting the new interval, new AL: \n" );
        for (Interval x: intervals) {
            System.out.println(x.start + " " + x.end);
        }
        return intervals;
    }

}

class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
































