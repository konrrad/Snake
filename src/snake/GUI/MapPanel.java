package snake.GUI;

import snake.logic.Direction;
import snake.logic.Map;
import snake.logic.Snake;
import snake.logic.Vector2D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MapPanel extends JPanel implements ActionListener, KeyListener{
    public final Map map;
    final Snake snake;
    private static final int MAP_WIDTH=10;
    private static final int MAP_HEIGHT=10;
    private final int step=1000;
    private Timer timer;


    public MapPanel()  {
        addKeyListener(this);
        map=new Map(new Vector2D(MAP_HEIGHT,MAP_WIDTH));
        this.setFocusable(true);
        snake=map.snake;
        timer=new Timer(step,this);
        timer.start();


    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        final int width=this.getWidth();
        final int height=this.getHeight();
        final int widthScale=Math.round(width/MAP_WIDTH);
        final int heightScale=Math.round(height/MAP_HEIGHT);


        this.setLocation(0,0);

        g.setColor(Color.WHITE);
        g.fillRect(0,0,width,height);

        g.setColor(Color.RED);
        g.fillOval(this.map.singlePart.position.x*widthScale,this.map.singlePart.position.y*heightScale,widthScale/4,heightScale/4);

        g.setColor(Color.BLACK);
        g.fillOval(snake.head.position.x*widthScale,snake.head.position.y*heightScale,widthScale/4,heightScale/4);
        if(!snake.tail.isEmpty())
        {
            snake.tail.forEach(element->
                    {
                        System.out.println(element.position);

                        g.fillOval(element.position.x*widthScale,element.position.y*heightScale,widthScale/4,heightScale/4);
                    }
                    );
            System.out.println("====================");
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        this.snake.move();
        this.repaint();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        char c = keyEvent.getKeyChar();
        System.out.println(c);
        this.snake.changeOrientation(Direction.charToDirection(c));
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

}
