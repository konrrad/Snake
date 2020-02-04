package snake.GUI;

import snake.logic.Direction;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFrame {
    JFrame frame;
    private static final int WIDTH=800;
    private static final int HEIGHT=800;
    MapPanel mapPanel;


    public GameFrame() {
        frame=new JFrame("Snake-gameFrame");
        this.frame.setSize(WIDTH,HEIGHT);
        this.mapPanel=new MapPanel();
        this.frame.add(mapPanel);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }


}
