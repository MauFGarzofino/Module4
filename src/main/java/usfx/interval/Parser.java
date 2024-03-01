package usfx.interval;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static Interval parseToInterval(int[] interval) {
        return new Interval(interval[0], interval[1]);
    }

    public static List<Interval> parseToIntervals(int[][] intervalsArray) {
        List<Interval> list = new ArrayList<>();
        for (int[] interval : intervalsArray) {
            if (interval.length == 2) { // Asegura que cada intervalo tenga exactamente 2 elementos.
                list.add(parseToInterval(interval));
            }
        }
        return list;
    }
}
