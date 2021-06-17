package clientServer;

import game.Game;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.net.Socket;

public class Connect implements Runnable{
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private boolean running;
    private Game game;
    public Connect(Game game, Socket socket){
        this.game = game;
        try {
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(this).start();
    }

    @Override
    public void run() {
        running = true;

        while (running){
            try {
                Object object = inputStream.readObject();
                game.packetRecieved(object);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendPacket (Object object){
        try {
            outputStream.writeObject(object);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() throws IOException {
        running = false;
        inputStream.close();
        outputStream.close();
    }
}
