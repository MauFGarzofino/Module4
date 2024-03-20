package assignments.squareframes;

public class Frame {
    int row, col, len;

    public Frame(int row, int col, int len) {
        this.row = row;
        this.col = col;
        this.len = len;
    }

    @Override
    public String toString() {
        return col + " " + row + " " + len;
    }
}
