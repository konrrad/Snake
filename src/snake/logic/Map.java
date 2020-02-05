package snake.logic;

import java.util.Random;

public class Map  {
    public final Snake snake;
    public final Vector2D size;
    private final Random randomizer=new Random();
    public SnakePart singlePart;
    public boolean gameover=false;



    public Map(final Vector2D size) {
        this.size=size;
        this.snake = new Snake(this,this.getInitialHeadPosition());
        this.singlePart=createSinglePart();
    }


    private Vector2D getInitialHeadPosition() {
        return new Vector2D(this.size.x/2,this.size.y/2);
    }
    private SnakePart createSinglePart()
    {
        Vector2D position=null;
        boolean found=false;
        while(!found)
        {
            final Vector2D potentialPosition=new Vector2D(randomizer.nextInt(this.size.x-1),randomizer.nextInt(this.size.y-1));
            if(!this.snake.head.position.equals(potentialPosition)&&
                    (this.snake.tail==null||this.snake.tail.stream().noneMatch(part->part.position.equals(potentialPosition))))
            {
                position=potentialPosition;
                found=true;
                System.out.println(position.toString());
            }
        }
        return new SnakePart(position);
    }

    public void positionChanged() {
        if(!this.isInBounds(this.snake.head.position))
            this.gameOver();
        if(this.snake.head.position.equals(this.singlePart.position))
        {
            this.snake.appendPart(this.singlePart);
            this.singlePart=createSinglePart();
        }
    }
    private boolean isInBounds(Vector2D position)
    {
        return position.x>=0&&position.y>=0&&position.x<this.size.x
                &&position.y<this.size.y;
    }
    public void gameOver()
    {
        gameover=true;
        System.out.println(gameover);

    }


}
