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
        super(Game.PLAYER_1);
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
        if(isMyTurn()){
            updateCell(x,y);
        }
    }

    @Override
    public void packetRecieved(Object object) {
        if (object instanceof PlayPacket) {
            PlayPacket packet = (PlayPacket) object;
            updateCell(packet.getX(), packet.getY());
        }
    }

    public void updateCell(int x, int y){
        if(cells[x][y] == Game.INIT){
            cells[x][y] = currentPlayer;
            if (currentPlayer == Game.PLAYER_1)
                currentPlayer = Game.PLAYER_2;
            else if (currentPlayer == Game.PLAYER_2)
                currentPlayer = Game.PLAYER_1;
            conn.sendPacket(new Update(cells,currentPlayer));
            gameGui.repaint();
            int winner = checkWin();
            if (winner != 0 ){
                endGame(winner);
            } else {
                int count  = 0;
                for (int i = 0; i < 3; i++){
                    for (int j = 0; j < 3; j++){
                        if (cells[i][j] == 0){
                            count++;
                        }
                    }
                }
                if (count == 9){
                    endGame(0);
                }
            }
        }
    }

    private void endGame(int winner){
        showWinner(winner);
        conn.sendPacket(new EndPacket(winner));
    }

    private int checkWin(){
        for (int player = Game.PLAYER_1; player <= Game.PLAYER_2; player++){
            for (int y = 0; y < 3; y++){
                int playerCount = 0;
                for (int x = 0; x < 3; x++){
                    if (cells[x][y] == player)
                        playerCount++;
                }
                if (playerCount == 3){
                    return player;
                }
            }
            for (int x = 0; x < 3; x++){
                int playerCount = 0;

                for (int y = 0; y < 3; y++){
                    if (cells[x][y] == player)
                        playerCount++;
                }
                if (playerCount == 3){
                    return player;
                }
            }
            int playerCount = 0;
            for (int coordinate = 0; coordinate < 3; coordinate++){
                if (cells[coordinate][coordinate] == player)
                    playerCount++;
            }
            if (playerCount == 3){
                return player;
            }
            playerCount = 0;
            for (int coordinate = 0; coordinate < 3; coordinate++){
                if (cells[2- coordinate][coordinate] == player)
                    playerCount++;
            }
            if (playerCount == 3){
                return player;
            }
        }
        return 0;
    }

    @Override
    public void close() {
        try {
            System.out.println("closed t");
            conn.close();
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("closed c");
            e.printStackTrace();
        }
    }

}
