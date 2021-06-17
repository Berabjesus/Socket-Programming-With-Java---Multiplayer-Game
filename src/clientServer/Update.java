package clientServer;

import java.io.Serializable;

public class Update implements Serializable {
    private int[][] cells;
    private int currentPlayer;

    public Update(int[][] cells, int currentPlayer){
        this.cells = cells;
        this.currentPlayer = currentPlayer;
    }

    public int[][] getCells() {
        return cells;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }
}
