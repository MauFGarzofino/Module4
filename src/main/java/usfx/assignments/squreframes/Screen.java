package usfx.assignments.squreframes;

public class Screen {
    char[][] screenMatrix;

    public Screen(int width, int height) {
        screenMatrix = new char[width][height];
    }

    public void setScreenMatrix(char[][] matrix) {
        this.screenMatrix = matrix;
    }

    public char[][] getScreenMatrix() {
        return screenMatrix;
    }

    public void applyFrame(Frame frame){
        System.out.println("Aplicamos una frame");
    }

    public void display() {
        System.out.println("Imprimir el estado actual de la pantalla");
    }
}

