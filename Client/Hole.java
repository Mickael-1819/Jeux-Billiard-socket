package materials;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;

public class Hole implements Serializable{
    int diameter;
    float x;
    float y;
    Color color;

    public Hole(int diameter, float x, float y, Color color){
        setDiameter(diameter);
        setX(x);
        setY(y);
        setColor(color);
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(getColor());
        Ellipse2D.Double circle = new Ellipse2D.Double(getX() - getDiameter() / 2, getY() - getDiameter() / 2, getDiameter(), getDiameter());
        g2d.fill(circle);
    }

    public int getDiameter() {
        return diameter;
    }
    public void setDiameter(int diameter) {
        this.diameter = diameter;
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
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
}