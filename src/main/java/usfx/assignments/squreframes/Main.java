package usfx.assignments.squreframes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[][] pantalla;

        pantalla = new String[20][50];

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 50; j++){
                pantalla[i][j] = ".";
            }
        }

        for(int i = 0; i < 20; i++){
            for (int j = 0; j < 50; j++){
                System.out.print(pantalla[i][j]);
            }
            System.out.println();
        }
    }
}
