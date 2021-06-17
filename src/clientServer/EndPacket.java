package clientServer;

import java.io.Serializable;

public class EndPacket implements Serializable {
    private int winner;

    public EndPacket(int winner){
        this.winner = winner;
    }

    public int getWinner() {
        return winner;
    }
}
