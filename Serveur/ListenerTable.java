package listeners;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.net.*;

import java.awt.event.*;
import javax.swing.*;

import materials.*;

public class ListenerTable implements MouseListener {
    Table table;
    Ball b;
//     boolean turn=false;
//     String fin = "fin";
    
//     ServerSocket ser;
   
//   Socket sock;

//     BufferedReader in;
    
//     PrintWriter  out;
   

 
    public ListenerTable(Table table){
        setTable(table);
        setB(table.getB());
    //     try{
    // ServerSocket ser = new ServerSocket(9090);
   
    // Socket sock = ser.accept();
  
    //   BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
      
    //   PrintWriter  out = new PrintWriter(sock.getOutputStream());
        
    //     } catch (Exception e) {
    //      e.printStackTrace();
    //      try {
    //         sock.close();
            
    //      } catch (Exception ex) {
    //      ex.printStackTrace();   
    //     }
    //     }
    }
    public void mouseClicked(MouseEvent e) {

    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }
    public void mousePressed(MouseEvent e) {
        
    }
    public void mouseReleased(MouseEvent e) {
        if (table.getB().getxSpeed() <= 0.1 && table.getB().getySpeed() <= 0.1) {
			float t = (float) Math.atan2(e.getY() - table.getB().getY(), e.getX() - table.getB().getX());
			
			table.getB().setxSpeed((Math.cos(t) * 10));
			table.getB().setySpeed((Math.sin(t) * 10));
            table.setNbClick(table.getNbClick()+1);
			table.repaint();
	    	}
            // if (sock!=null) {
            //     out.println(fin);
            //     out.flush();   
    
            // }
                
    
             
        }
    

    public Table getTable() {
        return table;
    }
    public void setTable(Table table) {
        this.table = table;
    }
    public Ball getB() {
        return b;
    }
    public void setB(Ball b) {
        this.b = b;
    }

}