package run;

import materials.*;


public class ThreadR implements Runnable {
    Table Table;
    boolean going;
    Ball b;         // white ball
    Ball[] balls;
    Hole[] holes;

    public ThreadR(Table Table){
        setTable(Table);
        setGoing(Table.isGoing());
        setB(Table.getB());
        setBalls(Table.getBalls());
        setHoles(Table.getHoles());   
    }

    public void run(){
        while (going) {
            b.move();
            for (int i = 0; i < getBalls().length; i++) {
                getBalls()[i].move();
            }

            int len = balls.length;
            for (int i = 0; i < len; i++) {
                Table.checkCollision(getB(), getBalls()[i]);
                for (int j = i; j < len-1; j++) {
                    if (getBalls()[i].visibility && getBalls()[j+1].visibility) {
                        Table.checkCollision(getBalls()[i], getBalls()[j+1]);
                    }
                }
            }
            for (int i = 0; i < getHoles().length; i++) {
                for (int j = 0; j < getBalls().length; j++) {
                    Table.checkCollision(getHoles()[i], getBalls()[j]);
                }
            }

            Table.repaint();

            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
            }
            
            b.frottement();
            for (int i = 0; i < getBalls().length; i++) {
                getBalls()[i].frottement();
            }
        }
    }

    public Table getTable() {
        return Table;
    }

    public void setTable(Table Table) {
        this.Table = Table;
    }

    public boolean isGoing() {
        return going;
    }

    public void setGoing(boolean going) {
        this.going = going;
    }

    public Ball getB() {
        return b;
    }

    public void setB(Ball b) {
        this.b = b;
    }
    
    public Ball[] getBalls() {
        return balls;
    }

    public void setBalls(Ball[] balls) {
        this.balls = balls;
    }

    public Hole[] getHoles() {
        return holes;
    }

    public void setHoles(Hole[] holes) {
        this.holes = holes;
    }
}
