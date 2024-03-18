package ascii;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main2Prueba {
    static final char BACKGROUND = '.';
    static final char VERTICAL = '\u2502';
    static final char HORIZONTAL = '\u2500';
    static final char IZQ_ARRIBA = '\u250c';
    static final char DER_ARRIBA = '\u2510';
    static final char IZQ_ABAJO = '\u2514';
    static final char DER_ABAJO = '\u2518';

    // Clase interna para representar un marco con su posición inicial y longitud.
    static class Frame {
        int row, col, len;

        Frame(int row, int col, int len) {
            this.row = row;
            this.col = col;
            this.len = len;
        }

        // Métodos estáticos para determinar si un carácter es una esquina o un lado.
        public static boolean isCorner(char c) {
            return c == IZQ_ARRIBA || c == DER_ARRIBA || c == IZQ_ABAJO || c == DER_ABAJO;
        }

        public static boolean isHorizontal(char c) {
            return c == HORIZONTAL;
        }

        public static boolean isVertical(char c) {
            return c == VERTICAL;
        }

        // Representación en String del marco.
        public String toString() {
            return col + " " + row + " " + len;
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Lectura del archivo... ");

        // Ruta del archivo de entrada.
        String filePath = "src/main/java/ascii/example - Ivan2 (1).txt";

        // Lectura del archivo y se guarda en un array bidimensional
        char[][] screen = readScreenFromFile(filePath);

        // Cola para almacenar los frames detectados
        Deque<Frame> frames = new ArrayDeque<>();

        // Búsqueda de frames
        searchFrames(frames, screen);

        // Imprime los marcos encontrados
        printFrames(frames);
    }

    // Lee el "lienzo" desde un archivo y lo convierte en un array bidimensional de caracteres.
    private static char[][] readScreenFromFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            lines.add(line);
        }
        char[][] screen = new char[lines.size()][lines.get(0).length()];
        for (int i = 0; i < lines.size(); i++) {
            screen[i] = lines.get(i).toCharArray();
        }
        reader.close();
        return screen;
    }

    // Itera sobre el array bidimensional
    // buscando posibles frames basándose en la presencia de esquinas.
    private static void searchFrames(Deque<Frame> frames, char[][] screen) {
        // Iteración para recorrer cada celda
        for (int row = 0; row < screen.length; row++) {
            for (int col = 0; col < screen[row].length; col++) {
                // Si encuentra una esquina...
                if (Frame.isCorner(screen[row][col])) {

                    // Una vez encontrada una esquina se itera sobre posibles longitudes
                    // Se inicia en 1 porque se necesita 1 carácter de alto o ancho para existir.
                    // Con 'screen[row].length - col' nos aseguramos que el bucle no intente buscar más allá
                    // de los límites del lienzo.
                    for (int len = 1; len < screen[row].length - col; len++) {

                        // Verificamos si hay frame válido
                        if (isValidFrame(screen, row, col, len)) {
                            // Si es válido lo añadimos a la cola
                            frames.addFirst(new Frame(row, col, len));

                            // Y lo maracamos
                            markFrame(screen, row, col, len);
                            // Salimos del bucle después de encontrar un marco válido
                            break;
                        }
                    }
                }
            }
        }
    }

    // Valida si un marco propuesto es válido verificando los bordes y las esquinas.
    private static boolean isValidFrame(char[][] screen, int row, int col, int proposedLen) {
        // Inicialmente, asume que todos los lados son válidos
        boolean validHorizontalTop = false, validHorizontalBottom = false;
        boolean validVerticalLeft = false, validVerticalRight = false;

        int rightCol = col + proposedLen;
        int bottomRow = row + proposedLen;

        // Asegúrate de que el marco propuesto no se salga de los límites de la pantalla
        if (bottomRow >= screen.length || rightCol >= screen[0].length) {
            return false;
        }

        // Comprueba la validez de los lados horizontales (superior e inferior)
        for (int i = col; i <= rightCol; i++) {
            validHorizontalTop |= (screen[row][i] == HORIZONTAL || Frame.isCorner(screen[row][i]));
            validHorizontalBottom |= (screen[bottomRow][i] == HORIZONTAL || Frame.isCorner(screen[bottomRow][i]));
        }

        // Comprueba la validez de los lados verticales (izquierdo y derecho)
        for (int i = row; i <= bottomRow; i++) {
            validVerticalLeft |= (screen[i][col] == VERTICAL || Frame.isCorner(screen[i][col]));
            validVerticalRight |= (screen[i][rightCol] == VERTICAL || Frame.isCorner(screen[i][rightCol]));
        }

        // El marco es válido si todos los lados son válidos
        return validHorizontalTop && validHorizontalBottom && validVerticalLeft && validVerticalRight;
    }

    // Marca el perímetro de un marco validado en el lienzo para indicar que ya ha sido procesado.
    private static void markFrame(char[][] screen, int row, int col, int len) {
        // Marcar bordes horizontales y verticales del cuadro
        for (int i = 0; i <= len; i++) {
            if (row + i < screen.length && col < screen[row].length) {
                screen[row + i][col] = '*';  // Lado vertical izquierdo
            }
            if (row + i < screen.length && col + len < screen[row].length) {
                screen[row + i][col + len] = '*';  // Lado vertical derecho
            }
            if (row < screen.length && col + i < screen[row].length) {
                screen[row][col + i] = '*';  // Lado horizontal superior
            }
            if (row + len < screen.length && col + i < screen[row].length) {
                screen[row + len][col + i] = '*';  // Lado horizontal inferior
            }
        }
    }

    private static void printFrames(Deque<Frame> frames) {
        System.out.println(frames.size());
        for (Frame frame : frames) {
            System.out.println(frame);
        }
    }
}
