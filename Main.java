import java.io.IOException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        //TheGame.main(args);
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type \"S\" to make this a server, or anything else to make it a client");
        if(keyboard.nextLine().toLowerCase().equals("s")){
            System.out.println("Enter port number:");
            Connect4Server server = new Connect4Server(keyboard.nextInt());
        }else{
            System.out.println("Enter host name and port number:");
            TheGame.main(args);
        }
    }
}
