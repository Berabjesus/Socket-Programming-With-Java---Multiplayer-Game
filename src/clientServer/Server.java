package clientServer;

import game.Game;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Game {

    private ServerSocket serverSocket;
    private Socket socket;
    private Connect conn;
    public Server() {
        try {
            serverSocket = new ServerSocket(PORT);
            socket = serverSocket.accept();
            conn = new Connect(this, socket);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Port " + PORT + " is not open");
            System.exit(-1);
        }
    }

    @Override
    public void inputRecieved(int x, int y) {
        System.out.println(x + "   " + y);
    }

    @Override
    public void packetRecieved(Object object) {

    }

    @Override
    public void close() {
        try {
            conn.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
