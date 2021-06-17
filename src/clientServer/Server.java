package clientServer;

import game.Game;

public class Server extends Game {
    @Override
    public void inputRecieved(int x, int y) {
        System.out.println(x + "   " + y);
    }

    @Override
    public void close() {

    }
}
