package game;

import clientServer.Client;
import clientServer.Server;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int input = Integer.parseInt(JOptionPane.showInputDialog("1 for server | 2 for client"));
        if (input == 1)
            new Server();
        else if (input == 2)
            new Client();
    }
}
