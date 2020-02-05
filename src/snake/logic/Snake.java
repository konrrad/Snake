package snake.logic;

import java.util.LinkedList;

public class Snake {
    public SnakePart head;
    public final LinkedList<SnakePart> tail;
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

    // used for testing
    //public Orientation getOrientation()
//    {
//        return orientation;
//    }
    public void move()
    {
        if(isSelfKilled())
        {
            this.map.gameOver();
        }
        Vector2D directionOfMove=orientation.toUnitVector();
        Vector2D olderElementPosition=head.position;
        Vector2D tmp=null;
        head.position=head.position.add(directionOfMove);
        if(!this.tail.isEmpty())
        {
            for(SnakePart element:this.tail)
            {
                tmp=element.position;
                element.position=olderElementPosition;
                olderElementPosition=tmp;
            }
        }


        this.map.positionChanged();
    }

    private boolean isSelfKilled() {
        return this.tail.stream().anyMatch(element->element.position.equals(head.position));
    }

    public void appendPart() {
        tail.addFirst(head);
        Vector2D headPosition=head.position;
        head=new SnakePart(headPosition.add(this.orientation.toUnitVector()));

    }
}
