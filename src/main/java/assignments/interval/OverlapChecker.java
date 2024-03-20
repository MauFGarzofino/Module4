package assignments.interval;

public class OverlapChecker {

    public static boolean hasOverlap(Interval interval1, Interval interval2) {
        return interval1.getStart() < interval2.getEnd() && interval2.getStart() < interval1.getEnd();
    }

}
