package snake.logic;

import java.util.Objects;

public class Vector2D {
    public int x;
    public int y;

    public Vector2D(int x, int y) {
        this.x = x;
        this.y=y;
    }
    public String toString()
    {
        return "Vector: ("+x+","+y+")";
    }
    public void add(Vector2D v)
    {
        x+=v.x;
        y+=v.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2D vector2D = (Vector2D) o;
        return x == vector2D.x &&
                y == vector2D.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
