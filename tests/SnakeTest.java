import org.junit.Test;
import org.junit.jupiter.api.DynamicTest;
import snake.logic.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class SnakeTest {
    @Test
    public void initialPosition()
    {
        Map map=new Map(new Vector2D(10,10));
        assertEquals(5,map.snake.head.position.x);
        assertEquals(5,map.snake.head.position.y);
    }
    @Test
    public void move1()
    {
        Map map=new Map(new Vector2D(10,10));
        map.snake.move();
        assertEquals(new Vector2D(5,6),map.snake.head.position);
        map.snake.move();
        assertEquals(new Vector2D(5,7),map.snake.head.position);
        map.snake.move();
        assertEquals(new Vector2D(5,8),map.snake.head.position);
        map.snake.move();
        assertEquals(new Vector2D(5,9),map.snake.head.position);
        map.snake.move();
        assertTrue(map.gameover);
    }

    @Test
    public void changeOrientation()
    {
        Map map=new Map(new Vector2D(10,10));
        Snake s=map.snake;
        map.snake.changeOrientation(Direction.LEFT);
        assertEquals(Orientation.WEST,s.getOrientation());
        map.snake.changeOrientation(Direction.LEFT);
        assertEquals(Orientation.SOUTH,s.getOrientation());
        map.snake.changeOrientation(Direction.RIGHT);
        assertEquals(Orientation.WEST,s.getOrientation());
        map.snake.changeOrientation(Direction.LEFT);
        assertEquals(Orientation.SOUTH,s.getOrientation());
        map.snake.changeOrientation(Direction.LEFT);
        assertEquals(Orientation.EAST,s.getOrientation());
        map.snake.changeOrientation(Direction.LEFT);
        assertEquals(Orientation.NORTH,s.getOrientation());
    }

    @Test
    public void move2()
    {
        Map map=new Map(new Vector2D(10,10));
        map.snake.move();
        assertEquals(new Vector2D(5,6),map.snake.head.position);
        map.snake.changeOrientation(Direction.LEFT);
        map.snake.move();
        assertEquals(new Vector2D(4,6),map.snake.head.position);
        map.snake.changeOrientation(Direction.LEFT);
        map.snake.move();
        assertEquals(new Vector2D(4,5),map.snake.head.position);
        map.snake.changeOrientation(Direction.LEFT);
        map.snake.move();
        assertEquals(new Vector2D(5,5),map.snake.head.position);
    }

}
