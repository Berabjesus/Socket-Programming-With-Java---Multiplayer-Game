package Game;

import gui.GameGui;
import gui.Window;

public class Game {
    private Window window;
    private GameGui gameGui;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    public  Game(){
        window = new Window("Tic Tac Toe", WIDTH, HEIGHT);
        gameGui = new GameGui();
        window.add(gameGui);
    }
}
