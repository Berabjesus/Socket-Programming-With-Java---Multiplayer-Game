package gui;

import game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameGui extends JPanel {
    private Game game;
    public GameGui(Game game) {
        this.game = game;
        addMouseListener(new Input());
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
                    graphics2D.drawImage(Resources.letters[cell - 1],x * Game.CELL, y * Game.CELL, Game.CELL -10, Game.CELL -10, null );
            }
        }
    }

    class Input extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1){
                game.inputRecieved(e.getY() / Game.CELL, e.getX() / Game.CELL);
            }
        }
    }
}


