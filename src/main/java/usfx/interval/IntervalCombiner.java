package usfx.interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IntervalCombiner {

    public static List<Interval> combineOverlappingIntervals(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }

        // Ordena los intervalos por su 'start'
        Collections.sort(intervals, Comparator.comparingInt(Interval::getStart));

        List<Interval> combinedIntervals = new ArrayList<>();
        Interval current = intervals.getFirst();
        combinedIntervals.add(current);

        for (int i = 1; i < intervals.size(); i++) {
            Interval next = intervals.get(i);
            if (OverlapChecker.hasOverlap(current, next)) {
                // Combina los intervalos que se solapan actualizando el 'end' del intervalo actual
                current.setEnd(Math.max(current.getEnd(), next.getEnd()));
            } else {
                // No hay solapamiento, así que se mueve al siguiente intervalo
                current = next;
                combinedIntervals.add(current);
            }
        }
        return combinedIntervals;
    }
}