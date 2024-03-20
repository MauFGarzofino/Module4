package draft_squareframes;

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

    // Clase interna para representar un marco con su posici?n inicial y longitud.
    static class Frame {
        int row, col, len;

        Frame(int row, int col, int len) {
            this.row = row;
            this.col = col;
            this.len = len;
        }

        // M?todos est?ticos para determinar si un car?cter es una esquina o un lado.
        public static boolean isCorner(char c) {
            return c == IZQ_ARRIBA || c == DER_ARRIBA || c == IZQ_ABAJO || c == DER_ABAJO;
        }

        public static boolean isHorizontal(char c) {
            return c == HORIZONTAL;
        }

        public static boolean isVertical(char c) {
            return c == VERTICAL;
        }

        // Representaci?n en String del marco.
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

        // B?squeda de frames
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
        for (int row = 0; row < screen.length; row++) {
            for (int col = 0; col < screen[row].length; col++) {
                // Si encuentra una esquina...
                if (Frame.isCorner(screen[row][col])) {
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

    private static boolean isValidFrame(char[][] screen, int row, int col, int len) {
        // Primero, determinamos el tipo de esquina para saber hacia dónde expandirnos
        char cornerType = screen[row][col];

        // Variables para determinar si cada lado del marco es válido
        boolean validTop = true, validBottom = true, validLeft = true, validRight = true;

        // Dependiendo del tipo de esquina, ajustamos nuestra estrategia de validación
        switch (cornerType) {
            case IZQ_ARRIBA:
                // Verificamos hacia la derecha para el borde superior y hacia abajo para el borde izquierdo
                for (int i = 1; i <= len && validTop && validLeft; i++) {
                    // Asegurarse de no exceder los límites de la matriz
                    if (row + i < screen.length && col + i < screen[row].length) {
                        validTop &= (screen[row][col + i] == HORIZONTAL || Frame.isCorner(screen[row][col + i]));
                        validLeft &= (screen[row + i][col] == VERTICAL || Frame.isCorner(screen[row + i][col]));
                    } else {
                        validTop = validLeft = false;
                    }
                }
                break;
            case DER_ARRIBA:
                // Para una esquina superior derecha, verificaríamos hacia la izquierda y hacia abajo
                // Esto requiere una lógica similar pero ajustando para comenzar desde la esquina derecha y moverse hacia la izquierda
                for (int i = 1; i <= len && validTop && validRight; i++) {
                    if (row + i < screen.length && col - i >= 0) { // Asegurarse de no exceder los límites de la matriz
                        validTop &= (screen[row][col - i] == HORIZONTAL || Frame.isCorner(screen[row][col - i]));
                        validRight &= (screen[row + i][col] == VERTICAL || Frame.isCorner(screen[row + i][col]));
                    } else {
                        validTop = validRight = false;
                    }
                }
                break;
            // Casos adicionales para IZQ_ABAJO y DER_ABAJO pueden ser agregados aquí
        }

        // Finalmente, comprobamos que todos los lados necesarios son válidos
        // Para simplificar, este ejemplo solo maneja dos tipos de esquinas
        // La lógica para esquinas inferiores sería similar pero ajustando para comenzar desde la esquina y moverse hacia arriba
        return validTop && validBottom && validLeft && validRight;
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
        System.out.println("Estado del lienzo después de marcar los marcos:");
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
