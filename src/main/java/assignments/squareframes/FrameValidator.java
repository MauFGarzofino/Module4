package assignments.squareframes;

import static assignments.squareframes.Constants.*;

public class FrameValidator {

    public static boolean isValidFrame(char[][] screen, int row, int col, int len) {
        char corner = screen[row][col];
        switch (corner) {
            case Constants.IZQ_ARRIBA:
                return checkFromTopLeft(screen, row, col, len);
            case Constants.DER_ARRIBA:
                return checkFromTopRight(screen, row, col, len);
            default:
                return false;
        }
    }

    private static boolean checkFromTopLeft(char[][] screen, int row, int col, int len) {
        boolean rightEdgeMarkedWithAsterisks = false;

        // Verificar borde horizontal hacia la derecha
        for (int i = 1; i < len - 1; i++) {
            if (col + i >= screen[0].length) {
                return false;
            }
            char currentChar = screen[row][col + i];
            if (currentChar != Constants.HORIZONTAL && currentChar != '*') {
                return false;
            }
            if (currentChar == '*') {
                rightEdgeMarkedWithAsterisks = true;
            }
        }
        if (rightEdgeMarkedWithAsterisks) {
            return true;
        }

        // Verificar esquina superior derecha
        int topRightCol = col + len - 1;
        if (topRightCol >= screen[0].length || (screen[row][topRightCol] != Constants.DER_ARRIBA && screen[row][topRightCol] != '*')) {
            return false;
        }

        // Verificar borde vertical hacia abajo desde la esquina superior izquierda
        for (int i = 1; i < len - 1; i++) {
            if (row + i >= screen.length || (screen[row + i][col] != Constants.VERTICAL && screen[row + i][col] != '*')) {
                return false;
            }
        }

        // Verificar esquina inferior izquierda
        int bottomLeftRow = row + len - 1;
        if (bottomLeftRow >= screen.length || (screen[bottomLeftRow][col] != Constants.IZQ_ABAJO && screen[bottomLeftRow][col] != '*')) {
            return false;
        }

        // Verificar borde inferior horizontal y esquina inferior derecha desde la esquina inferior izquierda
        if (!checkBottomAndRightEdge(screen, bottomLeftRow, col, topRightCol)) {
            return false;
        }

        return true;
    }

    private static boolean checkBottomAndRightEdge(char[][] screen, int bottomRow, int leftCol, int rightCol) {
        // Verificar borde inferior horizontal
        for (int i = leftCol + 1; i < rightCol; i++) {
            if (screen[bottomRow][i] != Constants.HORIZONTAL && screen[bottomRow][i] != '*') {
                return false;
            }
        }

        // Verificar esquina inferior derecha
        if (screen[bottomRow][rightCol] != Constants.DER_ABAJO && screen[bottomRow][rightCol] != '*') {
            return false;
        }

        return true;
    }

    private static boolean checkFromTopRight(char[][] screen, int row, int col, int len) {
        // Verificar borde horizontal hacia la izquierda

        // Recorre hacia la esquina sup izquierda, verificando que cada punto sea:
        // o un borde horizontal o un *
        for (int i = 1; i < len - 1; i++) {
            if (col - i < 0 || (screen[row][col - i] != Constants.HORIZONTAL && screen[row][col - i] != '*')) {
                return false;
            }
        }

        // Comprobación de que al final del borde horizontal izquierdo existe una esquina sup izquierda
        // Verificar esquina superior izquierda
        int topLeftCol = col - len + 1;
        if (topLeftCol < 0 || (screen[row][topLeftCol] != Constants.IZQ_ARRIBA && screen[row][topLeftCol] != '*')) {
            return false;
        }

        // Verificar borde vertical hacia abajo desde la esquina superior derecha
        for (int i = 1; i < len - 1; i++) {
            if (row + i >= screen.length || (screen[row + i][col] != Constants.VERTICAL && screen[row + i][col] != '*')) {
                return false;
            }
        }

        // Comprabacion de que al final se tenga una esquina inf derecha
        // Verificar esquina inferior derecha
        int bottomRightRow = row + len - 1;
        if (bottomRightRow >= screen.length || (screen[bottomRightRow][col] != Constants.DER_ABAJO && screen[bottomRightRow][col] != '*')) {
            return false;
        }

        // Verificar borde inferior horizontal y esquina inferior izquierda desde la esquina inferior derecha
        if (!checkBottomAndLeftEdge(screen, bottomRightRow, col, topLeftCol)) {
            return false;
        }

        return true;
    }

    private static boolean checkBottomAndLeftEdge(char[][] screen, int bottomRow, int rightCol, int leftCol) {
        // Verificar borde inferior horizontal
        for (int i = leftCol + 1; i < rightCol; i++) {
            if (screen[bottomRow][i] != Constants.HORIZONTAL && screen[bottomRow][i] != '*') {
                return false;
            }
        }

        // Verificar esquina inferior izquierda
        if (screen[bottomRow][leftCol] != Constants.IZQ_ABAJO && screen[bottomRow][leftCol] != '*') {
            return false;
        }

        return true;
    }
}

