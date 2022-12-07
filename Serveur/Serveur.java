package socket;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.net.*;

// import inc.Fonction;
// import objets.Table;

/*
 * www.codeurjava.com
 */
public class Serveur {

    public static void main(String[] test) {

        final ServerSocket serveurSocket;
        final Socket clientSocket;
        final BufferedReader in;
        final PrintWriter out;
        final Scanner sc = new Scanner(System.in);
        String ipWithDongle = "192.168.10.174";
        String local = "localhost";
        int port = 1793;

        try {
            serveurSocket = new ServerSocket(port);
            System.out.println("Mode serveur");
            System.out.println("En attente de client...");
            System.out.println("mon ip : " + local);
            System.out.println("port : " + port);
            clientSocket = serveurSocket.accept();
            System.out.println("Client trouve");
            out = new PrintWriter(clientSocket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            Thread recevoir = new Thread(new Runnable() {

                @Override
                public void run() {
              }
            });
            recevoir.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}