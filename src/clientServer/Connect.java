package clientServer;

import game.Game;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

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
            } catch (EOFException | SocketException | NullPointerException e){
                e.printStackTrace();
                running = false;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                running = false;
            }
        }
    }

    public void sendPacket (Object object){
        try {
            outputStream.reset();
            outputStream.writeObject(object);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() throws IOException {
        System.out.println("close");
        running = false;
        inputStream.close();
        outputStream.close();
    }
}
