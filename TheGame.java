import javax.swing.JFrame;
import java.awt.Component;
import java.io.IOException;
import java.util.Scanner;
public class TheGame extends JFrame{
    private static int width;
    private static int height;
    private static int boardWidth;
    private static int boardHeight;

    public TheGame() throws IOException, ClassNotFoundException{
        super("Connect4");
       width = 798;
       height = 684;
       boardWidth = 7;
       boardHeight = 5;
       Scanner keyboard = new Scanner(System.in);
        //add any other needed vars here

        setSize(width, height);
        //int port = keyboard.nextInt();
        //String hostname = keyboard.next();
        GraphicsStuff game = new GraphicsStuff(boardWidth, boardHeight, width, height, 8000, "localhost");

        ((Component)game).setFocusable(true);
        getContentPane().add(game);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[]) throws IOException, ClassNotFoundException{
        TheGame run = new TheGame();
    }
}
