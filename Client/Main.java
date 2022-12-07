package run;

import javax.swing.JFrame;
import java.util.Timer;
import java.util.Vector;

import materials.*;
import windows.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

//import inputOutput.MyObjectInputStream;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        final Socket clientSocket;
        final BufferedReader in;
        final PrintWriter out;
        final Scanner sc = new Scanner(System.in);// pour lire à partir du clavier

        String ipLocal = "localhost";
        int port = 1793;

        try {
            /*
             * les informations du serveur ( port et adresse IP ou nom d'hote
             * 127.0.0.1 est l'adresse local de la machine
             */
            System.out.println("Mode client");
            clientSocket = new Socket(ipLocal, port);
            System.out.println("server trouve : "+ipLocal);

    
            
                GameFrame game = new GameFrame();
            // flux pour envoyer
            out = new PrintWriter(clientSocket.getOutputStream());
            // flux pour recevoir
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            Thread envoyer = new Thread(new Runnable() {
                String msg;

                @Override
                public void run() {
                    while (true) {
                        msg = sc.nextLine();
                        out.println(msg);
                        out.flush();
                    }
                }
            });
            envoyer.start(); 

            Thread recevoir = new Thread(new Runnable() {
                //String msg;
                
//                Fonction f = new Fonction();
                
                // if(relationObjIs == null) {
                //     relationObjIs = new ObjectInputStream(is);
                // }

                @Override
                public void run() {
                    try {

                        OutputStream os = clientSocket.getOutputStream(); // send message au client

                        InputStream is = clientSocket.getInputStream();
                                 
            
                        DataOutputStream mpSent = new DataOutputStream(os); // pour l'envoie de l'objet
                                               
                        
      

                      while(true){ 
                        DataInputStream input = new DataInputStream(is);
                        String hu = input.readUTF();

                        String vi = input.readUTF();
                     
                        String huhus1 = input.readUTF();
                        String huhus2 = input.readUTF();
                        String huhus3 = input.readUTF();
                        String huhus4 = input.readUTF();
                        String huhus5 = input.readUTF();
                        String huhus6 = input.readUTF();
                     
                        String vivis1 = input.readUTF();
                        String vivis2 = input.readUTF();
                        String vivis3 = input.readUTF();
                        String vivis4 = input.readUTF();
                        String vivis5 = input.readUTF();
                        String vivis6 = input.readUTF();
                        
                        // System.out.println(hu);
                         String[] first = hu.split(":");    
                       String X=first[0];
                        String Y=first[1];


                        String[] second = vi.split(":");
                        String vX= second[0];
                        String vY = second[1];

                         String[] bs1 = huhus1.split(":");    
                        String BX1=bs1[0];
                         String BY1=bs1[1];

                         String[] bs2 = huhus2.split(":");    
                        String BX2=bs2[0];
                         String BY2=bs2[1];

                         String[] bs3 = huhus3.split(":");    
                         String BX3=bs3[0];
                          String BY3=bs3[1];

                          String[] bs4 = huhus4.split(":");    
                          String BX4=bs4[0];
                           String BY4=bs4[1];
  
                           String[] bs5 = huhus5.split(":");    
                           String BX5=bs5[0];
                            String BY5=bs5[1];
   
                            String[] bs6 = huhus6.split(":");    
                            String BX6=bs6[0];
                             String BY6=bs6[1];
    
                             String[] vs1 = vivis1.split(":");    
                             String vXs1=vs1[0];
                              String vYs1=vs1[1];
  
                              String[] vs2 = vivis2.split(":");    
                              String vXs2=vs2[0];
                               String vYs2=vs2[1];
       
                               String[] vs3 = vivis3.split(":");    
                               String vXs3=vs3[0];
                                String vYs3=vs3[1];
        
                                String[] vs4 = vivis4.split(":");    
                                String vXs4=vs4[0];
                                 String vYs4=vs4[1];
         
                                 String[] vs5 = vivis5.split(":");    
                                 String vXs5=vs5[0];
                                  String vYs5=vs5[1];
          
                                  
                                 String[] vs6 = vivis6.split(":");    
                                 String vXs6=vs6[0];
                                  String vYs6=vs6[1];
                        // Vector<String> XcoordBalls =new Vector<String>();
                        // XcoordBalls.add(BX);
                        // XcoordBalls.add(BY); 


                         game.getTable().getB().setX(Float.parseFloat(X));
                         game.getTable().getB().setY(Float.parseFloat(Y));
                         game.getTable().getB().setxSpeed(Float.parseFloat(vX));
                         game.getTable().getB().setySpeed(Float.parseFloat(vY));
                         
                         game.getTable().getBalls()[0].setX(Float.parseFloat(BX1));
                         game.getTable().getBalls()[0].setY(Float.parseFloat(BY1));
                         game.getTable().getBalls()[0].setxSpeed(Float.parseFloat(vXs1));
                         game.getTable().getBalls()[0].setySpeed(Float.parseFloat(vYs1));
                          
                            game.getTable().getBalls()[1].setX(Float.parseFloat(BX2));
                            game.getTable().getBalls()[1].setY(Float.parseFloat(BY2));
                            game.getTable().getBalls()[1].setxSpeed(Float.parseFloat(vXs2));
                            game.getTable().getBalls()[1].setySpeed(Float.parseFloat(vYs2));
                              
                            game.getTable().getBalls()[2].setX(Float.parseFloat(BX3));
                            game.getTable().getBalls()[2].setY(Float.parseFloat(BY3));
                            game.getTable().getBalls()[2].setxSpeed(Float.parseFloat(vXs3));
                            game.getTable().getBalls()[2].setySpeed(Float.parseFloat(vYs3));
                              
                            game.getTable().getBalls()[3].setX(Float.parseFloat(BX4));
                            game.getTable().getBalls()[3].setY(Float.parseFloat(BY4));
                            game.getTable().getBalls()[3].setxSpeed(Float.parseFloat(vXs4));
                            game.getTable().getBalls()[3].setySpeed(Float.parseFloat(vYs4));
                              
                            game.getTable().getBalls()[4].setX(Float.parseFloat(BX5));
                            game.getTable().getBalls()[4].setY(Float.parseFloat(BY5));
                            game.getTable().getBalls()[4].setxSpeed(Float.parseFloat(vXs5));
                            game.getTable().getBalls()[4].setySpeed(Float.parseFloat(vYs5));
                              
                            game.getTable().getBalls()[5].setX(Float.parseFloat(BX6));
                            game.getTable().getBalls()[5].setY(Float.parseFloat(BY6));
                            game.getTable().getBalls()[5].setxSpeed(Float.parseFloat(vXs6));
                            game.getTable().getBalls()[5].setySpeed(Float.parseFloat(vYs6));
                              
                        



                    //     game.getTable().getB().setY(Y);
                    //         game.getTable().repaint();
                    //    // Table tab = (Table)hu;
                       // game.setTable(tab);
                     //   new Thread(new ThreadR()).start();
                  
                    //  DataOutputStream mpSent = new DataOutputStream(os); // pour l'envoie de l'objet
                    
                    //  String cood =game.getTable().getB().getX()+":"+game.getTable().getB().getY();
                    // // System.out.println(cood);
                    //  String vitesse =game.getTable().getB().getxSpeed()+":"+game.getTable().getB().getySpeed();    
       
                    //  mpSent.writeUTF(cood);
                    //  mpSent.writeUTF(vitesse);
 
                    //      String ballscord1 =game.getTable().getBalls()[0].getX()+":"+game.getTable().getBalls()[0].getY();
                    //      String ballscord2 =game.getTable().getBalls()[1].getX()+":"+game.getTable().getBalls()[1].getY();
                    //      String ballscord3 =game.getTable().getBalls()[2].getX()+":"+game.getTable().getBalls()[2].getY();
                    //      String ballscord4 =game.getTable().getBalls()[3].getX()+":"+game.getTable().getBalls()[3].getY();
                    //      String ballscord5 =game.getTable().getBalls()[4].getX()+":"+game.getTable().getBalls()[4].getY();
                    //      String ballscord6 =game.getTable().getBalls()[5].getX()+":"+game.getTable().getBalls()[5].getY();
                    //      // System.out.println(ballscord1);
                    //      // System.out.println(ballscord2);
                    //      // System.out.println(ballscord3);
                    //      // System.out.println(ballscord4);
                    //      // System.out.println(ballscord5);
                    //      // System.out.println(ballscord6);
                         
                    //      mpSent.writeUTF(ballscord1);
                    //      mpSent.writeUTF(ballscord2);
                    //      mpSent.writeUTF(ballscord3);
                    //      mpSent.writeUTF(ballscord4);
                    //      mpSent.writeUTF(ballscord5);
                    //      mpSent.writeUTF(ballscord6);
                                    
 
                    //       String vitballs1 = game.getTable().getBalls()[0].getxSpeed()+":"+game.getTable().getBalls()[0].getySpeed();
                    //       String vitballs2 = game.getTable().getBalls()[1].getxSpeed()+":"+game.getTable().getBalls()[1].getySpeed();
                    //       String vitballs3 = game.getTable().getBalls()[2].getxSpeed()+":"+game.getTable().getBalls()[2].getySpeed();
                    //       String vitballs4 = game.getTable().getBalls()[3].getxSpeed()+":"+game.getTable().getBalls()[3].getySpeed();
                    //       String vitballs5 = game.getTable().getBalls()[4].getxSpeed()+":"+game.getTable().getBalls()[4].getySpeed();
                    //       String vitballs6 = game.getTable().getBalls()[5].getxSpeed()+":"+game.getTable().getBalls()[5].getySpeed();
                                         
                    //                  mpSent.writeUTF(vitballs1);
                    //                  mpSent.writeUTF(vitballs2);
                    //                  mpSent.writeUTF(vitballs3);
                    //                  mpSent.writeUTF(vitballs4);
                    //                  mpSent.writeUTF(vitballs5);
                    //                  mpSent.writeUTF(vitballs6);
                    //  //  //               System.out.println(ballscord);
                    
 
 
                         
               
                    //      mpSent.flush();
                     
                    
                    }
                      


                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    // try {                                                             ;,,,,,,,,,,,,hjmhj;;;;;;;;;;;h
                    //     System.out.println("Serveur deconnecté");
                    //     out.close();
                    // } catch (IOException e) {
                    //     e.printStackTrace();
                    // }
                    

                }
            });
            recevoir.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
    
}