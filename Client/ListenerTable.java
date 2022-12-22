package listeners;

import java.awt.event.*;
import javax.swing.*;

import materials.*;

public class ListenerTable implements MouseListener {
    Table table;
    Ball b;

    public ListenerTable(Table table){
        setTable(table);
        setB(table.getB());
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
            System.out.println("mety");
		}
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