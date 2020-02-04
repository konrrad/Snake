package snake.logic;

public enum Direction {
    RIGHT,
    LEFT;

    public static Direction charToDirection(char c) {
        if(c=='a'||c=='A') return  RIGHT;
        else if(c=='d'||c=='D') return LEFT;
        return null;
    }
}
