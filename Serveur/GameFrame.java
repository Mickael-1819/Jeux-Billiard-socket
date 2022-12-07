package windows;

import javax.swing.*;

import org.w3c.dom.css.RGBColor;

import java.awt.*;
import materials.*;
import listeners.*;

public class GameFrame extends JFrame {
    Table table = new Table(6);
    boolean turn = false;       
    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
    public boolean getTurn() {
        return turn;
    }
    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public GameFrame()throws Exception{
        setTitle("Billiard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridLayout(1, 2));
        table.addMouseListener(new ListenerTable(table));
        add(table);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
