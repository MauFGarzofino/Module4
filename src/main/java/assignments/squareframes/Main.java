package assignments.squareframes;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
            String filePath = "src/main/java/assignments/squareframes/examples/example - Ivan.txt";
            char[][] content = ScreenReader.readScreenFromFile(filePath);
            Screen screen = new Screen(content);
            FrameDetector detector = new FrameDetector(screen);
            var frames = detector.detectFrames();

            System.out.println("Frames encontrados: " + frames.size());
            frames.forEach(System.out::println);
    }
}
