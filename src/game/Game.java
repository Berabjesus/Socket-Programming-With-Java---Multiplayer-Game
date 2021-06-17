package game;

import gui.GameGui;
import gui.Window;

import javax.swing.*;

public abstract class Game {
    private Window window;
    protected GameGui gameGui;
    protected int[][] cells;
    protected int currentPlayer;
    protected int thisPlayer;
    public final int PORT = 4000;
    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;
    public static final int CELL = WIDTH / 3;
    public static final int INIT = 0, PLAYER_1 = 1, PLAYER_2 = 2;
    public Game(int thisPlayer){
        this.thisPlayer = thisPlayer;
        String isServer = thisPlayer == 1 ? " | Server" : "";
        window = new Window(this,"Tic Tac Toe - Player " + thisPlayer + isServer , WIDTH, HEIGHT);
        gameGui = new GameGui(this);
        cells = new int[3][3];
        window.add(gameGui);
        window.setVisible(true);
        currentPlayer = PLAYER_1;
    }

    protected void showWinner(int winner){
        if (winner == 0){
            JOptionPane.showMessageDialog(null, "TIE");
        }else {
            JOptionPane.showMessageDialog(null, "Player " + winner + " has won the game.");
        }
        System.exit(-1);
    }

    protected boolean isMyTurn() {
        if(thisPlayer == currentPlayer)
            return true;
        return false;
    }

    public int[][] getCells() {
        return cells;
    }

    public abstract void close();

    public abstract void packetRecieved(Object object);

    public abstract void inputRecieved(int x, int y);
}
