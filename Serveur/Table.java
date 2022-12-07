package materials;

import java.awt.*;
import java.awt.geom.Line2D;
import java.io.Serializable;

import javax.swing.*;

import materials.*;
import run.*;
import windows.*;

public class Table extends JPanel implements Serializable {
    int WIDTH = 400;
    int HEIGHT = 600;
    int diameterBall = 20;
    Ball b;
    boolean going = true;
    Ball[] balls;
    int nbBall;
    Hole[] holes = new Hole[6];
    double deltaX;
    double deltaY;
    double distance;
    int nbClick;
    String[] namePlayers = new String[2];


    public int getNbClick() {
        return nbClick;
    }

    public void setNbClick(int nbClick) {
        this.nbClick = nbClick;
    }

    public String[] getNamePlayers() {
        return namePlayers;
    }

    public void setNamePlayers(String[] namePlayers) {
        this.namePlayers = namePlayers;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public void setWIDTH(int wIDTH) {
        WIDTH = wIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(int hEIGHT) {
        HEIGHT = hEIGHT;
    }

    public int getDiameterBall() {
        return diameterBall;
    }

    public void setDiameterBall(int diameterBall) {
        this.diameterBall = diameterBall;
    }

    public Ball getB() {
        return b;
    }

    public void setB(Ball b) {
        this.b = b;
    }

    public boolean isGoing() {
        return going;
    }

    public void setGoing(boolean going) {
        this.going = going;
    }

    public Ball[] getBalls() {
        return balls;
    }

    public void setBalls(Ball[] balls) {
        this.balls = balls;
    }
    public int getNbBall() {
        return nbBall;
    }

    public void setNbBall(int nbBall) {
        this.nbBall = nbBall;
    }
    
    public Hole[] getHoles() {
        return holes;
    }

    public void setHoles(Hole[] holes) {
        this.holes = holes;
    }

    public double getDeltaX() {
        return deltaX;
    }

    public void setDeltaX(double deltaX) {
        this.deltaX = deltaX;
    }

    public double getDeltaY() {
        return deltaY;
    }

    public void setDeltaY(double deltaY) {
        this.deltaY = deltaY;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Table(int nbBall){
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(new Color(21, 88, 67));
        setNbBall(nbBall);
        setBalls(new Ball[getNbBall()]);
        setNbClick(1);
        b = new Ball(WIDTH/2, (HEIGHT*2)/3, getDiameterBall(), 1, new Color(255,255,255), true);
        b.setxSpeed(0);
        b.setySpeed(0);
        
        startBalls();
        startHoles(50);


        new Thread(new ThreadR(this)).start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        b.draw(g);
        
        for (int i = 0; i < getBalls().length; i++) {
            if (balls[i].visibility) {
                balls[i].draw(g);
            }
        }
        for (int i = 0; i < getHoles().length; i++) {
            holes[i].draw(g);
        }

        if (getNbClick()%2 != 0) {
            g.drawString("Player 1", (getWIDTH()/2)-10, 50);
        } else{
            g.drawString("Player 2", (getWIDTH()/2)-10, 50);
        }
    }

    public void checkCollision(Ball b1, Ball b2){
        deltaX = Math.abs(b1.getX() - b2.getX());
        deltaY = Math.abs(b1.getY() - b2.getY());
        double distances = deltaX * deltaX + deltaY * deltaY;
        
        if (distances < (b1.getDiameter() / 2 + b2.getDiameter() / 2) * (b1.getDiameter() / 2 + b2.getDiameter() / 2)) {
            // coefficient of restitution
            double eta = 1.0; 
            // relative position (normal vector)
            double px = b2.getX() - b1.getX();
            double py = b2.getY() - b1.getY();
            // unit normal vector 
            double vnorm = Math.hypot(px,py);
            px = px/vnorm;
            py = py/vnorm;
            double m1 = b1.getMasse();
            double m2 = b1.getMasse();
            double mt = m1+m2;
            // velocity components (normal)
            double v1 = b1.getxSpeed() *px+ b1.getySpeed() *py;
            double v2 = b2.getxSpeed()*px+b2.getySpeed()*py;
            // velocity components (tangente)
            double qx = py;
            double qy = -px;
            double u1 = b1.getxSpeed()*qx+b1.getySpeed()*qy;
            double u2 = b2.getxSpeed()*qx+b2.getySpeed()*qy;
            // new velocity
            double v1f = ((eta+1.0)*m2*v2+v1*(m1-eta*m2))/mt;
            double v2f = ((eta+1.0)*m1*v1+v2*(m2-eta*m1))/mt;
            // change to new velocity.
            b1.setxSpeed(v1f*px+u1*qx);
            b1.setySpeed(v1f*py+u1*qy);
            b2.setxSpeed(v2f*px+u2*qx);
            b2.setySpeed(v2f*py+u2*qy);
        }
    }
    
    public void checkCollision(Hole h, Ball b){
        deltaX = Math.abs(h.getX() - b.getX());
        deltaY = Math.abs(h.getY() - b.getY());
        double distances = deltaX * deltaX + deltaY * deltaY;
        
        if (distances < (h.getDiameter() / 2 + b.getDiameter() / 2) * (h.getDiameter() / 2 + b.getDiameter() / 2)) {
            b.setVisibility(false);
            b.setX(0);
            b.setY(0);
            b.setxSpeed(0);
            b.setySpeed(0);
            
        }
    }

    public void startBalls(){
        float y = getHEIGHT()/5;
        int desc = (int)(getNbBall()/2);
        int k = 0;
        while (k < getNbBall()) {
            float x = (WIDTH/2) - (desc * (getDiameterBall()/2));
            for (int j = 0; j < desc; j++) {
                if (k < getNbBall()) {
                    balls[k] = new Ball(x, y, getDiameterBall(), 1, new Color(255,40,40), true);
                    balls[k].setxSpeed(0);
                    balls[k].setySpeed(0);
                }
                k++;
                x += getDiameterBall()+1;
            }
            y += getDiameterBall();
            if (desc > 1){desc--;}
        }
    }

    public void startHoles(int diameter){
        Color color = new Color(0, 0, 0);
        float x = 0, y = 0;
        int k = 0;
        for (int i = 0; i < holes.length/3; i++) {
            for (int j = 0; j < holes.length/2; j++) {
                holes[k] = new Hole(diameter, x, y, color);
                y += getHEIGHT()/2;
                k++;
            }
            x = (float)getWIDTH();
            y = 0;
        }
    }

}