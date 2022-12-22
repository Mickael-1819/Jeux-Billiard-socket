package run;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.net.*;


import javax.swing.JFrame;
import java.util.Timer;
import java.util.Vector;

import materials.*;
import windows.*;

public class Main {

    public static void main(String[] args) {

        final ServerSocket serveurSocket;
        final Socket clientSocket;
        final BufferedReader in;
        final PrintWriter out;
          String ipWithDongle = "192.168.10.174";
        String local = "localhost";
        int port = 1793;
        try{
            GameFrame game = new GameFrame();
      
            
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
                try{
            
            OutputStream os = clientSocket.getOutputStream(); // send message au client

            InputStream is = clientSocket.getInputStream();
                     

            
                while(true){
                    DataOutputStream mpSent = new DataOutputStream(os); // pour l'envoie de l'objet
                    // coordonne de la boule blanche
                    String cood =game.getTable().getB().getX()+":"+game.getTable().getB().getY();
                   // System.out.println(cood);
                   
                   // vitesse de la boule blanche
                   
                    String vitesse =game.getTable().getB().getxSpeed()+":"+game.getTable().getB().getySpeed();    
      
                    mpSent.writeUTF(cood);
                    mpSent.writeUTF(vitesse);

                        String ballscord1 =game.getTable().getBalls()[0].getX()+":"+game.getTable().getBalls()[0].getY();
                        String ballscord2 =game.getTable().getBalls()[1].getX()+":"+game.getTable().getBalls()[1].getY();
                        String ballscord3 =game.getTable().getBalls()[2].getX()+":"+game.getTable().getBalls()[2].getY();
                        String ballscord4 =game.getTable().getBalls()[3].getX()+":"+game.getTable().getBalls()[3].getY();
                        String ballscord5 =game.getTable().getBalls()[4].getX()+":"+game.getTable().getBalls()[4].getY();
                        String ballscord6 =game.getTable().getBalls()[5].getX()+":"+game.getTable().getBalls()[5].getY();

                        mpSent.writeUTF(ballscord1);
                        mpSent.writeUTF(ballscord2);
                        mpSent.writeUTF(ballscord3);
                        mpSent.writeUTF(ballscord4);
                        mpSent.writeUTF(ballscord5);
                        mpSent.writeUTF(ballscord6);
                                   

                         String vitballs1 = game.getTable().getBalls()[0].getxSpeed()+":"+game.getTable().getBalls()[0].getySpeed();
                         String vitballs2 = game.getTable().getBalls()[1].getxSpeed()+":"+game.getTable().getBalls()[1].getySpeed();
                         String vitballs3 = game.getTable().getBalls()[2].getxSpeed()+":"+game.getTable().getBalls()[2].getySpeed();
                         String vitballs4 = game.getTable().getBalls()[3].getxSpeed()+":"+game.getTable().getBalls()[3].getySpeed();
                         String vitballs5 = game.getTable().getBalls()[4].getxSpeed()+":"+game.getTable().getBalls()[4].getySpeed();
                         String vitballs6 = game.getTable().getBalls()[5].getxSpeed()+":"+game.getTable().getBalls()[5].getySpeed();
                                        
                                    mpSent.writeUTF(vitballs1);
                                    mpSent.writeUTF(vitballs2);
                                    mpSent.writeUTF(vitballs3);
                                    mpSent.writeUTF(vitballs4);
                                    mpSent.writeUTF(vitballs5);
                                    mpSent.writeUTF(vitballs6);
                   


                        
              
                        mpSent.flush();
                    
                  }
                   }catch(Exception exp){System.out.println(exp);}

        }
        });
        recevoir.start();
    } catch (IOException e) {
        e.printStackTrace();
    }
}catch(Exception ex){System.out.println(ex);}
}

}