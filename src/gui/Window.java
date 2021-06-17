package gui;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window(String title, int width, int height){
        super(title);
//        setSize(width, height);
        getContentPane().setPreferredSize(new Dimension(width,height));
        pack();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
