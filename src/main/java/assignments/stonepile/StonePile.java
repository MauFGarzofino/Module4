package assignments.stonepile;


//                      [ ]
//                    /     \
//                  /         \
//                [2]         [ ]
//               /  \         /  \
//             /     \      /     \
//          [2,3]   [2]   [3]     [ ]

public class StonePile {
    private static int findMinDiff(int[] weights, int n, int sumCalculated, int totalSum) {
        // Si todas las piedras han sido consideradas,
        // retorna la diferencia mínima
        if (n == 0) {
            System.out.println("Con SumCalculated:" + sumCalculated +" : "+ Math.abs((totalSum - sumCalculated) - sumCalculated));
            return Math.abs((totalSum - sumCalculated) - sumCalculated);
        }

        // Explora dos posibilidades para cada piedra:
        // 1. Incluir la piedra en el primer montón
        // 2. No incluir la piedra en el primer montón (iría al segundo montón)
        // Y elige la que minimice la diferencia de peso

        return Math.min(findMinDiff(weights, n - 1, sumCalculated + weights[n - 1], totalSum),
                findMinDiff(weights, n - 1, sumCalculated, totalSum));
    }

    public static int minimalDifference(int[] weights) {
        int totalSum = 0;
        for (int weight : weights) {
            totalSum += weight;
        }
        return findMinDiff(weights, weights.length, 0, totalSum);
    }

    public static void main(String[] args) {
        int[] weights = {2, 3};
        System.out.println("Minimal possible weight difference between stone piles: " + minimalDifference(weights));
    }
}
