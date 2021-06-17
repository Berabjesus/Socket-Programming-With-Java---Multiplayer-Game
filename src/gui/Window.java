package gui;

import game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Window extends JFrame {
    private Game game;
    public Window(Game game, String title, int width, int height){
        super(title);
        this.game = game;
        getContentPane().setPreferredSize(new Dimension(width,height));
        pack();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        addWindowListener(new Listener());
        setVisible(true);
    }

    class Listener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            game.close();
        }
    }

}
