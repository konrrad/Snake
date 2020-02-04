import org.junit.Test;
import snake.logic.Map;
import snake.logic.Vector2D;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapTest {
    @Test
    public void getInitialHeadPosition()
    {
        Map map=new Map(new Vector2D(13,13));
        assertEquals(map.size.x/2,6);
        assertEquals(map.size.y/2,6);

    }


}
