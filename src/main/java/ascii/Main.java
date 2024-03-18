package ascii;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
    static final char BACKGROUND = '.';
    static final char VERTICAL = '\u2502';
    static final char HORIZONTAL = '\u2500';
    static final char IZQ_ARRIBA = '\u250c';
    static final char DER_ARRIBA = '\u2510';
    static final char IZQ_ABAJO = '\u2514';
    static final char DER_ABAJO = '\u2518';

    static class Frame {
        int row, col, len;

        Frame(int row, int col, int len) {
            this.row = row;
            this.col = col;
            this.len = len;
        }

        public static boolean isCorner(char c) {
            return c == IZQ_ARRIBA || c == DER_ARRIBA || c == IZQ_ABAJO || c == DER_ABAJO;
        }

        public static boolean isHorizontal(char c) {
            return c == HORIZONTAL;
        }

        public static boolean isVertical(char c) {
            return c == VERTICAL;
        }

        public String toString() {
            return col + " " + row + " " + len;
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Leyendo input de archivo...");
        // Asegúrate de cambiar la ruta del archivo según corresponda
        String filePath = "Z://ECampus//Module4//Module4//src//main//java//ascii//example - Ivan2 (1).txt";
        char[][] screen = readScreenFromFile(filePath);
        Deque<Frame> frames = new ArrayDeque<>();
        searchFrames(frames, screen);
        printFrames(frames);
    }

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

    private static void searchFrames(Deque<Frame> frames, char[][] screen) {
        for (int row = 0; row < screen.length; row++) {
            for (int col = 0; col < screen[row].length; col++) {
                if (Frame.isCorner(screen[row][col])) {
                    for (int len = 1; len < screen[row].length - col; len++) {
                        if (isValidFrame(screen, row, col, len)) {
                            frames.addFirst(new Frame(row, col, len));
                            markFrame(screen, row, col, len);
                            break;
                        }
                    }
                }
            }
        }
    }

    private static boolean isValidFrame(char[][] screen, int row, int col, int len) {
        // Verificar esquinas del cuadro
        if (screen[row][col] != IZQ_ARRIBA || screen[row][col + len] != DER_ARRIBA ||
                screen[row + len][col] != IZQ_ABAJO || screen[row + len][col + len] != DER_ABAJO) {
            System.out.println("false");
            return false;
        }
        // Verificar bordes horizontales del cuadro
        for (int i = 1; i < len; i++) {
            if (screen[row][col + i] != HORIZONTAL || screen[row + len][col + i] != HORIZONTAL) {
                System.out.println("false");
                return false;
            }
        }
        // Verificar bordes verticales del cuadro
        for (int i = 1; i < len; i++) {
            if (screen[row + i][col] != VERTICAL || screen[row + i][col + len] != VERTICAL) {
                System.out.println("false");
                return false;
            }
        }
        return true;
    }

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
