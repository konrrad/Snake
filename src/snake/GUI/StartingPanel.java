package snake.GUI;
import javax.swing.*;
import java.awt.event.*;

public class StartingPanel implements ActionListener {
    private final JFrame menu;
    private static final int WIDTH=800;
    private static final int HEIGHT=800;

    public StartingPanel() {
        this.menu = new JFrame("Snake");
        JButton start = new JButton("Start");
        JPanel panel = new JPanel();
        JLabel title = new JLabel("<html><span style='color: teal;'>SNAKE</span></html>");

        title.setFont (title.getFont().deriveFont(64.0f));

        menu.setSize(WIDTH,HEIGHT);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        start.setFont(title.getFont().deriveFont(64.0f));

        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        panel.add(title);
        panel.add(start);

        menu.add(panel);

        start.addActionListener(this);
        menu.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        GameFrame gf=new GameFrame();
        this.menu.setVisible(false);

    }


}
