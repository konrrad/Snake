package snake.logic;

import java.util.LinkedList;
import java.util.List;

public class Snake {
    public final SnakePart head;
    public final List<SnakePart> tail;
    private final Map map;
    private Orientation orientation;


    public Snake(Map map, Vector2D position)
    {
        this.map=map;
        head=new SnakePart(position);
        tail=new LinkedList<>();
        orientation=Orientation.NORTH;
    }
    public void changeOrientation(Direction d)
    {
        if(d==Direction.LEFT)
            this.orientation=orientation.orientatnionLeft(this.orientation);
        else if(d==Direction.RIGHT)
            this.orientation=orientation.orientatnionRight(this.orientation);

    }

    //@TODO delete? -- used for testing
    public Orientation getOrientation()
    {
        return orientation;
    }
    public void move()
    {
        //@TODO mistake???
        if(orientation.toUnitVector() == null) throw new IllegalArgumentException("Cannot move when orientation is null");
        Vector2D direction=orientation.toUnitVector();
        SnakePart previous=head;
        SnakePart temp=null;
        head.position.add(direction);
        if(!this.tail.isEmpty())
        {
            for(SnakePart element:this.tail)
            {
                temp=element;
                element.position=previous.position;
                previous=temp;
            }
        }


        this.map.positionChanged();
    }
}
