package assignments.squareframes;

import static assignments.squareframes.Constants.*;

public class FrameValidator {
    public static boolean isValidFrame(char[][] screen, int row, int col, int len) {
        char corner = screen[row][col];
        boolean hasValidEdges = false;

        // Identificar el tipo de esquina y verificar bordes basándose en esa esquina.
        if (isCorner(corner)) {
            // Esquina superior izquierda
            if (corner == Constants.IZQ_ARRIBA) {
                hasValidEdges = checkHorizontalEdge(screen, row, col, len, true) &&
                        checkVerticalEdge(screen, row, col, len, true);
            }
            // Esquina superior derecha
            else if (corner == Constants.DER_ARRIBA) {
                hasValidEdges = checkHorizontalEdge(screen, row, col, len, false) &&
                        checkVerticalEdge(screen, row, col, len, true);
            }
            // Esquina inferior izquierda
            else if (corner == Constants.IZQ_ABAJO) {
                hasValidEdges = checkHorizontalEdge(screen, row, col, len, true) &&
                        checkVerticalEdge(screen, row - len + 1, col, len, false);
            }
            // Esquina inferior derecha
            else if (corner == Constants.DER_ABAJO) {
                hasValidEdges = checkHorizontalEdge(screen, row, col - len + 1, len, false) &&
                        checkVerticalEdge(screen, row - len + 1, col, len, false);
            }
        }

        return hasValidEdges;
    }

    private static boolean checkHorizontalEdge(char[][] screen, int row, int col, int len, boolean right) {
        for (int x = 1; x < len - 1; x++) {
            int columnIndex = right ? col + x : col - x;
            if (!isHorizontal(screen[row][columnIndex]) && screen[row][columnIndex] != '*') {
                return false;
            }
        }
        return true;
    }

    private static boolean checkVerticalEdge(char[][] screen, int row, int col, int len, boolean down) {
        char corner = screen[row][col];

        if (corner == Constants.IZQ_ARRIBA) {
            for (int y = 1; y <= len - 1; y++) {
                int rowIndex = down ? row + y : row - y;

                if (!isVertical(screen[rowIndex][col]) && screen[rowIndex][col] != IZQ_ABAJO ) {
                    return false;
                }
            }
        }

        if (corner == DER_ARRIBA){
            for (int y = 1; y <= len - 1; y++) {
                int rowIndex = down ? row + y : row - y;
                if (!isVertical(screen[rowIndex][col]) && screen[rowIndex + 1][col] == DER_ABAJO ) {
                    return false;
                }
            }
        }

        return true;
    }
}


