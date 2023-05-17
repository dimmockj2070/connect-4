import javax.swing.JFrame;
import java.awt.Component;
import java.util.Scanner;
public class TheGame extends JFrame{
    private static int width;
    private static int height;
    private static int boardWidth;
    private static int boardHeight;

    public TheGame(){
        super("Connect4");
       width = 798;
       height = 684;
       boardWidth = 7;
       boardHeight = 5;
        //add any other needed vars here

        setSize(width, height);
        GraphicsStuff game = new GraphicsStuff(boardWidth, boardHeight, width, height);

        ((Component)game).setFocusable(true);
        getContentPane().add(game);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[]){
        TheGame run = new TheGame();
    }
}
