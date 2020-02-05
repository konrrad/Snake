package snake.logic;

public enum Orientation {
    NORTH,
    SOUTH,
    WEST,
    EAST;
    public Orientation orientatnionLeft(Orientation o)
    {
        if(o==NORTH) return WEST;
        else if(o==WEST) return SOUTH;
        else if(o==SOUTH) return EAST;
        else if(o==EAST) return NORTH;
        else throw new IllegalArgumentException("Orientation can't be null.");
    }
    public Orientation orientatnionRight(Orientation o)
    {
        if(o==NORTH) return EAST;
        else if(o==EAST) return SOUTH;
        else if(o==SOUTH) return WEST;
        else if(o==WEST) return NORTH;
        else throw new IllegalArgumentException("Orientation can't be null.");
    }
    public Vector2D toUnitVector()
    {
        if(this==NORTH) return new Vector2D(0,1);
        else if(this==EAST) return new Vector2D(1,0);
        else if(this==SOUTH) return new Vector2D(0,-1);
        else if(this==WEST) return new Vector2D(-1,0);
        else throw new IllegalArgumentException("Orientation can't be null.");
    }
}
