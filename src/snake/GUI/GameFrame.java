package snake.GUI;
import javax.swing.*;


public class GameFrame {
    private final JFrame frame;
    private static final int WIDTH=800;
    private static final int HEIGHT=800;
    private final MapPanel mapPanel;


    public GameFrame() {
        frame=new JFrame("Snake");
        this.frame.setSize(WIDTH,HEIGHT);
        this.mapPanel=new MapPanel();
        this.frame.add(mapPanel);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }


}
