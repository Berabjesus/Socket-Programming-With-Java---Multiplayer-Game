package Game;

import gui.GameGui;
import gui.Window;

public class Game {
    private Window window;
    private GameGui gameGui;
    private int[][] fields;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    public  Game(){
        window = new Window("Tic Tac Toe", WIDTH, HEIGHT);
        gameGui = new GameGui();
        fields = new int[3][3];
        window.add(gameGui);
    }
}
