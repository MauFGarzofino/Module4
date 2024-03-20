package assignments.squareframes;

public class FrameValidator {
    public static boolean isValidFrame(char[][] screen, int row, int col, int len) {
        // Verificar esquinas
        char topLeft = screen[row][col];
        char topRight = screen[row][col + len - 1];
        char bottomLeft = screen[row + len - 1][col];
        char bottomRight = screen[row + len - 1][col + len - 1];

        if (!isCornerValid(topLeft) || !isCornerValid(topRight) ||
                !isCornerValid(bottomLeft) || !isCornerValid(bottomRight)) {
            return false;
        }

        // Verificar bordes
        for (int i = 1; i < len - 1; i++) {
            char top = screen[row][col + i];
            char bottom = screen[row + len - 1][col + i];
            char left = screen[row + i][col];
            char right = screen[row + i][col + len - 1];

            if (!(isHorizontal(top) || top == '*') ||
                    !(isHorizontal(bottom) || bottom == '*') ||
                    !(isVertical(left) || left == '*') ||
                    !(isVertical(right) || right == '*')) {
                return false;
            }
        }

        return true;
    }

    private static boolean isCornerValid(char c) {
        return c == Constants.IZQ_ARRIBA || c == Constants.DER_ARRIBA ||
                c == Constants.IZQ_ABAJO || c == Constants.DER_ABAJO || c == '*';
    }

    private static boolean isHorizontal(char c) {
        return c == Constants.HORIZONTAL || c == '*';
    }

    private static boolean isVertical(char c) {
        return c == Constants.VERTICAL || c == '*';
    }
}




