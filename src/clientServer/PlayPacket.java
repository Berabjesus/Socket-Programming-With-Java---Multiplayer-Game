package clientServer;

import java.io.Serializable;

public class PlayPacket implements Serializable {
    private int x;
    private int y;
    public PlayPacket(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
