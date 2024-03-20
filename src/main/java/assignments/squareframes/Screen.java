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
        // Marcar los bordes horizontales
        for (int i = 0; i < len; i++) {
            setCharAt(col + i, row, '*');
            setCharAt(col + i, row + len - 1, '*');
        }

        // Marcar los bordes verticales
        for (int i = 0; i < len; i++) {
            setCharAt(col, row + i, '*');
            setCharAt(col + len - 1, row + i, '*');
        }

        printContent();
    }

    private void setCharAtIfNotMarked(int x, int y, char c) {
        if (content[y][x] != '*') {
            content[y][x] = c;
        }
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


