package draft.random;

import java.util.ArrayList;
import java.util.Random;

public class RandomNumbers {
    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> numerosImpares = new ArrayList<>();
        ArrayList<Integer> numerosPares = new ArrayList<>();
        ArrayList<Integer> mulDeCinco = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            int numero = rand.nextInt(100);
            numbers.add(numero);

            if (numero % 2 != 0) {
                numerosImpares.add(numero);
            }
            if (numero % 2 == 0) {
                numerosPares.add(numero);
            }
            if (numero % 5 == 0) {
                mulDeCinco.add(numero);
            }
        }

        System.out.println("Números impares: " + numerosImpares);
        System.out.println("Números pares: " + numerosPares);
        System.out.println("Múltiplos de 5: " + mulDeCinco);
    }
}
