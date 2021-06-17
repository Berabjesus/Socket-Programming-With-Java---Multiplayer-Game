package gui;

import Game.Game;

import javax.swing.*;
import java.awt.*;

public class GameGui extends JPanel {
    private Game game;
    public GameGui(Game game) {
        this.game = game;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setStroke(new BasicStroke(10));
        graphics.drawLine(Game.CELL,0,Game.CELL,Game.HEIGHT);
        graphics.drawLine(Game.CELL * 2,0,Game.CELL * 2,Game.HEIGHT);
        graphics.drawLine(0,Game.CELL,Game.WIDTH,Game.CELL);
        graphics.drawLine(0,Game.CELL * 2,Game.WIDTH,Game.CELL * 2);

        for (int x = 0; x < 3; x++){
            for (int y = 0; y < 3; y++){
                int cell = game.getCells()[x][y];
                if (cell != 0)
                    graphics2D.drawImage(Resources.letters[cell], Game.CELL -10, Game.CELL -10, null );
            }
        }
    }
}
