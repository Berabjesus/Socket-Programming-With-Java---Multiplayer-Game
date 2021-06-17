package gui;

import Game.Game;

import javax.swing.*;
import java.awt.*;

public class GameGui extends JPanel {
    public GameGui() {
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setStroke(new BasicStroke(10));
        graphics.drawLine(200,0,200,Game.HEIGHT);
        graphics.drawLine(400,0,400,Game.HEIGHT);
        graphics.drawLine(0,200,Game.WIDTH,200);
        graphics.drawLine(0,400,Game.WIDTH,400);
    }
}
