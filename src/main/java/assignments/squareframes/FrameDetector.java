package assignments.squareframes;

import java.util.ArrayList;
import java.util.List;

public class FrameDetector {
    private Screen screen;

    public FrameDetector(Screen screen) {
        this.screen = screen;
    }

    public List<Frame> detectFrames() {
        List<Frame> frames = new ArrayList<>();
        for (int row = 0; row < screen.getHeight(); row++) {
            for (int col = 0; col < screen.getWidth(); col++) {
                char c = screen.getCharAt(col, row);
                if (Constants.isCorner(c)) {
                    for (int len = 2; col + len <= screen.getWidth() && row + len <= screen.getHeight(); len++) {
                        if (FrameValidator.isValidFrame(screen.getContent(), row, col, len)) {
                            frames.add(new Frame(row, col, len));
                            screen.markFrame(row, col, len);
                            break; // Para simular el comportamiento del 'goto', detenemos la búsqueda una vez que encontramos un marco válido.
                        }
                    }
                }
            }
        }
        return frames;
    }
}
