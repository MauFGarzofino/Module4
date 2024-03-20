package draft_squareframes;

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
        System.out.println("Lectura del archivo... ");
        String filePath = "src/main/java/ascii/example - Ivan2 (1).txt";
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

    private static boolean isValidFrame(char[][] screen, int row, int col, int proposedLen) {
        // Asume que todos los bordes inician siendo válidos
        boolean isTopValid = true, isBottomValid = true, isLeftValid = true, isRightValid = true;

        // Determina los límites finales del marco propuesto
        int rightLimit = col + proposedLen;
        int bottomLimit = row + proposedLen;

        // Asegúrate de que el marco propuesto no se extienda fuera del lienzo
        if (bottomLimit >= screen.length || rightLimit >= screen[0].length || col < 0 || row < 0) {
            return false;
        }

        // Verificar el borde superior e inferior
        for (int i = col; i <= rightLimit && (isTopValid || isBottomValid); i++) {
            if (screen[row][i] != HORIZONTAL && screen[row][i] != '*' && !Frame.isCorner(screen[row][i])) {
                isTopValid = false;
            }
            if (screen[bottomLimit][i] != HORIZONTAL && screen[bottomLimit][i] != '*' && !Frame.isCorner(screen[bottomLimit][i])) {
                isBottomValid = false;
            }
        }

        // Verificar el borde izquierdo y derecho
        for (int i = row; i <= bottomLimit && (isLeftValid || isRightValid); i++) {
            if (screen[i][col] != VERTICAL && screen[i][col] != '*' && !Frame.isCorner(screen[i][col])) {
                isLeftValid = false;
            }
            if (screen[i][rightLimit] != VERTICAL && screen[i][rightLimit] != '*' && !Frame.isCorner(screen[i][rightLimit])) {
                isRightValid = false;
            }
        }

        // Si todos los bordes son válidos, el marco es válido
        return isTopValid && isBottomValid && isLeftValid && isRightValid;
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
