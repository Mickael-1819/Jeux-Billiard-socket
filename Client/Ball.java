package materials;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;

import javax.swing.*;

public class Ball implements Serializable {

    float x;
    float y;
    double xSpeed;
    double ySpeed;
    float diameter;
    float masse;
    Color color;
    public boolean visibility;

    public Ball(float x, float y, float diameter, float masse, Color color, boolean visibility) {
        this.x = x;
        this.y = y;
        this.masse = masse;
        this.diameter = diameter;
        this.color = color;
        this.visibility = visibility;
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(color);
        Ellipse2D.Double circle = new Ellipse2D.Double(getX() - getDiameter() / 2, getY() - getDiameter() / 2, getDiameter(), getDiameter());
        g2d.fill(circle);
    }

    public void move() {
        setX((float) (getX() + getxSpeed()));

        if (getX() - getDiameter() / 2 < 2) {
            setX(getDiameter() / 2);
            setxSpeed(-getxSpeed());
        } else if (getX() + getDiameter() / 2 > 400) {
            setxSpeed(-getxSpeed());
        }

        setY((float) (getY() + getySpeed()));

        if (getY() - getDiameter() / 2 < 0) {
            setySpeed(-getySpeed());
        } else if (getY() + getDiameter() / 2 > 600) {
            setY(600 - getDiameter() / 2);
            setySpeed(-getySpeed());
        }
    }

    public void frottement(){
        setxSpeed(getxSpeed()*0.99);
        setySpeed(getySpeed()*0.99);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public double getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    public double getySpeed() {
        return ySpeed;
    }

    public void setySpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }

    public float getDiameter() {
        return diameter;
    }

    public void setDiameter(float diameter) {
        this.diameter = diameter;
    }

    public float getMasse() {
        return masse;
    }

    public void setMasse(float masse) {
        this.masse = masse;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

}