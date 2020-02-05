import snake.GUI.StartingPanel;

public class Game {
    public static void main(String[] args) {
        try
        {
            StartingPanel startingPanel=new StartingPanel();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }


    }
}
