package game;

import gui.GameGui;
import gui.Window;

public abstract class Game {
    private Window window;
    private GameGui gameGui;
    private int[][] cells;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    public static final int CELL = WIDTH / 3;
    public static final int INIT = 0, PLAYER_1 = 1, PLAYER_2 = 2;
    public Game(){
        window = new Window(this,"Tic Tac Toe", WIDTH, HEIGHT);
        gameGui = new GameGui(this);
        cells = new int[3][3];
        window.add(gameGui);
    }

    public int[][] getCells() {
        return cells;
    }

    public abstract void close();

    public abstract void inputRecieved(int x, int y);
}
