package gui;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Resources {
    public static BufferedImage[] letters;
    static {
        try {
            letters = new BufferedImage[2];
            letters[0] = loadImage("res/x.png");
            letters[1] = loadImage("res/o.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage loadImage (String path) throws IOException {
        return ImageIO.read(Class.class.getResource(path));
    }
}
