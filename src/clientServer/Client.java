package clientServer;

import game.Game;

import java.io.IOException;
import java.net.Socket;

public class Client extends Game {

    private Socket socket;
    private Connect conn;

    public Client (){
        super(Game.PLAYER_2);

        try {
            socket = new Socket("localhost", PORT);
            conn = new Connect(this, socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void packetRecieved(Object object) {
        if (object instanceof Update){
            Update packet = (Update) object;
            cells = packet.getCells();
            currentPlayer = packet.getCurrentPlayer();
        } else if(object instanceof EndPacket){
            EndPacket packet = (EndPacket) object;
            showWinner(packet.getWinner());
        }
        gameGui.repaint();
    }

    @Override
    public void inputRecieved(int x, int y) {
        if (isMyTurn()){
            conn.sendPacket(new PlayPacket(x, y));
        }
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
