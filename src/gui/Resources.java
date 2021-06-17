package gui;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Resources {
    public static BufferedImage[] letters;
    static {
            letters = new BufferedImage[2];
            letters[0] = loadImage("res/x.png");
            letters[1] = loadImage("res/o.png");
    }

    private static BufferedImage loadImage (String path) {
        try {
            System.out.println("test");
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return null;
    }
}
