package assignments.squareframes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScreenReader {
    public static char[][] readScreenFromFile(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                lines.add(line);
            }
        }

        char[][] screen = new char[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            screen[i] = lines.get(i).toCharArray();
        }
        return screen;
    }
}
