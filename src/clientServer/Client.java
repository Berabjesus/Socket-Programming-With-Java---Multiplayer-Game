package clientServer;

import game.Game;

import java.io.IOException;
import java.net.Socket;

public class Client extends Game {

    private Socket socket;
    private Connect conn;

    public Client (){
        try {
            socket = new Socket("localhost", PORT);
            conn = new Connect(this, socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void packetRecieved(Object object) {

    }

    @Override
    public void inputRecieved(int x, int y) {

    }

    @Override
    public void close() {
        try {
            conn.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
