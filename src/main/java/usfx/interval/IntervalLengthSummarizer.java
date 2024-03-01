package usfx.interval;

import java.util.List;

public class IntervalLengthSummarizer {

    public static int sumLengthsOfIntervals(List<Interval> intervals) {
        int sum = 0;
        for (Interval interval : intervals) {
            sum += interval.getLength();
        }
        return sum;
    }
}