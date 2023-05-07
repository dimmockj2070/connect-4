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
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter Width: ");
        width=keyboard.nextInt();
        System.out.print("Enter Height: ");
        height = keyboard.nextInt();
        System.out.print("Enter board width and height: ");
        boardWidth = keyboard.nextInt();
        boardHeight = keyboard.nextInt();
        //add any other needed vars here

        if(width == 0){
            width = 800; // maybe change these
        }
        if(height == 0){
            height = 600;
        }
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
