package assignments.squareframes;

public class Screen {
    private char[][] content;

    public Screen(char[][] content) {
        this.content = content;
    }

    public char getCharAt(int x, int y) {
        return content[y][x];
    }

    public void setCharAt(int x, int y, char c) {
        content[y][x] = c;
    }

    public int getWidth() {
        return content[0].length;
    }

    public int getHeight() {
        return content.length;
    }

    public char[][] getContent() {
        return content;
    }

    public void markFrame(int row, int col, int len) {
        char cornerType = content[row][col];

        int startRow = row, startCol = col;
        if (cornerType == Constants.DER_ARRIBA) {
            //len = 3;
            startCol = col - len + 1;
        } else if (cornerType == Constants.IZQ_ABAJO) {
            startRow = row - len + 1;
        } else if (cornerType == Constants.DER_ABAJO) {
            startRow = row - len + 1;
            startCol = col - len + 1;
        }

        // Marcar los bordes horizontales y verticales desde las coordenadas de inicio calculadas.
        for (int i = 0; i < len; i++) {
            setCharAt(startCol + i, startRow, '*'); // Top edge
            setCharAt(startCol + i, startRow + len - 1, '*'); // Bottom edge
            setCharAt(startCol, startRow + i, '*'); // Left edge
            setCharAt(startCol + len - 1, startRow + i, '*'); // Right edge
        }

        printContent();
    }

    private void printContent() {
        for (char[] row : content) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println("--------------------------------");
    }
}


