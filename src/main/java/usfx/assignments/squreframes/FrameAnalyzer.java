package usfx.assignments.squreframes;

import java.util.ArrayList;
import java.util.List;

public class FrameAnalyzer {
    public static List<Frame> analize(Screen screen) {
        List<Frame> frames = new ArrayList<>();
        char[][] screenMatrix = screen.getScreenMatrix();

        for (int y = 0; y < screenMatrix.length; y++) {
            for (int x = 0; x < screenMatrix[y].length; x++) {
                if (screenMatrix[y][x] != '.') {
                    // Encontrar las esquinas y bordes para determinar el tamaño del marco
                    // Asegúrate de que el carácter actual es una esquina antes de procesar
                    // Agregar el marco identificado a la lista de marcos
                }
            }
        }
        return frames;
    }
}
