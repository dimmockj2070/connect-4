import java.io.*;
import java.net.*;

public class Connect4Server {
    private ServerSocket serverSocket;
    private Socket player1;
    private Socket player2;

    public Connect4Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void run(boolean isP1Turn) throws IOException, ClassNotFoundException{
        ObjectOutputStream outputStreamP1 = new ObjectOutputStream(player1.getOutputStream());
        ObjectOutputStream outputStreamP2 = new ObjectOutputStream(player2.getOutputStream());
        if(isP1Turn){
            ObjectInputStream inputStreamP1 = new ObjectInputStream(player1.getInputStream());
            Message m = (Message) inputStreamP1.readObject();
            if(m.getType().equals("p1m")){
                outputStreamP2.writeObject(m);
                System.out.println("server sending message to player 2" + " " + m);
                if(!m.getType().equals("win")){
                    run(false);
                }
            }else{
                run(true);
            }
        }else{
            ObjectInputStream inputStreamP2 = new ObjectInputStream(player2.getInputStream());
            Message m = (Message) inputStreamP2.readObject();
            System.out.println(m);
            if(m.getType().equals("p2m")){
                outputStreamP1.writeObject(m);
                System.out.println("server sending message to player 1" + " " + m);
                if(!m.getType().equals("win")){
                    run(true);
                }
            }else{
                run(false);
            }
        }

    }

    public void start() throws IOException, ClassNotFoundException {
        System.out.println("Waiting for players to connect...");
        
        player1 = serverSocket.accept();
        System.out.println("Player 1 has connected!");
        ObjectOutputStream outputStreamP1 = new ObjectOutputStream(player1.getOutputStream());

        
        // tell it what player it is
        Message message = new Message("p", 0); // it will interpret that as "you are player 1"
        outputStreamP1.writeObject(message);
        outputStreamP1.flush();

        player2 = serverSocket.accept();
        System.out.println("Player 2 has connected!");
        ObjectOutputStream outputStreamP2 = new ObjectOutputStream(player2.getOutputStream());

        // tell it what player it is
        message = new Message("p", 1);
        outputStreamP2.writeObject(message);

        run(true);
        
        // TODO: handle game logic and communication
    }
}
