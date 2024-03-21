package assignments.interval;

import java.util.List;

public class IntervalManager {

    public static void main(String[] args) {
        // Matriz
        int[][] intervalsArray = new int[][] {
                {2, 3},
                {1, 3},
                {8, 10},
                {15, 18}
        };

        // Paso 1: Parsear la matriz de intervalos a objetos Interval
        List<Interval> intervals = Parser.parseToIntervals(intervalsArray);

        // Paso 2: Combinar los intervalos que se solapan
        List<Interval> combinedIntervals = IntervalCombiner.combineOverlappingIntervals(intervals);

        // Paso 3: Sumar las longitudes de los intervalos combinados
        int totalLength = IntervalLengthSummarizer.sumLengthsOfIntervals(combinedIntervals);

        System.out.println("Intervalos combinados:");
        for (Interval interval : combinedIntervals) {
            System.out.println("[" + interval.getStart() + ", " + interval.getEnd() + "]");
        }
        System.out.println("Suma total de longitudes: " + totalLength);
    }
}