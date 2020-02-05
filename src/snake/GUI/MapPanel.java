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
    private final Map map;
    private final Snake snake;
    private static final int MAP_WIDTH=10;
    private static final int MAP_HEIGHT=10;
    private static final int step=1000;
    private final Timer timer;


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
        if(this.map.gameover)
        {
            this.removeAll();
            g.setColor(Color.RED);
            g.setFont(Font.getFont(Font.SANS_SERIF));
            g.setFont(g.getFont().deriveFont(30.0f));

            g.drawString("GAME OVER! SCORE: "+(snake.tail.size()+1),width/3,height/2);
            return;
        }

        final int widthScale=width/MAP_WIDTH;
        final int heightScale=height/MAP_HEIGHT;


        this.setLocation(0,0);

        g.setColor(Color.WHITE);
        g.fillRect(0,0,width,height);

        g.setColor(Color.RED);
        g.fillOval(this.map.getSinglePartPosition().x*widthScale,this.map.getSinglePartPosition().y*heightScale,widthScale/4,heightScale/4);

        g.setColor(Color.BLACK);
        g.fillRect(snake.head.position.x*widthScale,snake.head.position.y*heightScale,widthScale/4,heightScale/4);
        if(!snake.tail.isEmpty())
        {
            snake.tail.forEach(element->
                        g.fillOval(element.position.x*widthScale,element.position.y*heightScale,
                                widthScale/4,heightScale/4));
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(this.map.gameover)
        {
            this.timer.stop();
            this.repaint();
            return;
        }
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
