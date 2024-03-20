package draft_squareframes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static draft_squareframes.MainV2.Frame.isCorner;

public class MainV2 {
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
        String filePath = "src/main/java/ascii/example - Ivan3.txt";

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
                if (isCorner(screen[row][col])) {

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
    private static boolean isValidFrame(char[][] screen, int row, int col, int len) {
        char cornerType = screen[row][col];
        // Asumimos que todos los bordes son inválidos inicialmente.
        boolean validTop = true, validBottom = true, validLeft = true, validRight = true;

        // Verifica los límites del frame propuesto para evitar índices fuera de rango.
        if ((cornerType == IZQ_ARRIBA || cornerType == DER_ARRIBA) && (row + len >= screen.length || col + len >= screen[row].length || col - len < 0)) {
            return false;
        }
        if ((cornerType == IZQ_ABAJO || cornerType == DER_ABAJO) && (row - len < 0 || col - len < 0 || col + len >= screen[row].length)) {
            return false;
        }

        // Dependiendo del tipo de esquina, ajusta la verificación de cada borde.
        switch (cornerType) {
            case IZQ_ARRIBA:
                validTop = checkLine(screen, row, col, len, true, true);
                validLeft = checkLine(screen, row, col, len, false, true);
                break;
            case DER_ARRIBA:
                validTop = checkLine(screen, row, col - len, len, true, false);
                validRight = checkLine(screen, row, col, len, false, true);
                break;
            case IZQ_ABAJO:
                validBottom = checkLine(screen, row - len, col, len, true, true);
                validLeft = checkLine(screen, row, col, len, false, false);
                break;
            case DER_ABAJO:
                validBottom = checkLine(screen, row - len, col - len, len, true, false);
                validRight = checkLine(screen, row, col, len, false, false);
                break;
        }

        return validTop && validBottom && validLeft && validRight;
    }

    private static boolean checkLine(char[][] screen, int startRow, int startCol, int len, boolean isHorizontal, boolean isPositive) {
        for (int offset = 0; offset <= len; offset++) {
            int currentRow = isHorizontal ? startRow : (isPositive ? startRow + offset : startRow - offset);
            int currentCol = isHorizontal ? (isPositive ? startCol + offset : startCol - offset) : startCol;

            // Asegúrate de que estamos dentro de los límites del array.
            if (currentRow < 0 || currentRow >= screen.length || currentCol < 0 || currentCol >= screen[0].length) {
                return false;
            }

            char currentChar = screen[currentRow][currentCol];
            // Verifica si el caracter actual es parte de un borde o una esquina.
            if (!(currentChar == HORIZONTAL || currentChar == VERTICAL || Frame.isCorner(currentChar))) {
                return false;
            }
        }
        return true;
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
        printScreen(screen);
    }

    private static void printFrames(Deque<Frame> frames) {
        System.out.println(frames.size());
        for (Frame frame : frames) {
            System.out.println(frame);
        }
    }

    private static void printScreen(char[][] screen) {
        for (int row = 0; row < screen.length; row++) {
            for (int col = 0; col < screen[row].length; col++) {
                System.out.print(screen[row][col]);
            }

            System.out.println(); // Salto de línea después de imprimir cada fila
        }
    }
}