package assignments.squareframes;

public class Constants {
    public static final char BACKGROUND = '.';
    public static final char VERTICAL = '\u2502';
    public static final char HORIZONTAL = '\u2500';
    public static final char IZQ_ARRIBA = '\u250c';
    public static final char DER_ARRIBA = '\u2510';
    public static final char IZQ_ABAJO = '\u2514';
    public static final char DER_ABAJO = '\u2518';

    public static boolean isCorner(char c) {
        return c == IZQ_ARRIBA || c == DER_ARRIBA || c == IZQ_ABAJO || c == DER_ABAJO;
    }

    public static boolean isHorizontal(char c) {
        return c == HORIZONTAL;
    }

    public static boolean isVertical(char c) {
        return c == VERTICAL;
    }
}
