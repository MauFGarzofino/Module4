package assignments.squareframes;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
            String filePath = "src/main/java/assignments/squreframes/examples/example - Ivan2 (1).txt";
            char[][] content = ScreenReader.readScreenFromFile(filePath);
            Screen screen = new Screen(content);
            FrameDetector detector = new FrameDetector(screen);
            var frames = detector.detectFrames();

            System.out.println("Frames encontrados: " + frames.size());
            frames.forEach(System.out::println);
    }
}
