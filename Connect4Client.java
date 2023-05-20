import java.io.*;
import java.net.*;
    
public class Connect4Client { // just a way to communicate with the server, GraphicsStuff still does it all.
    private Socket socket;
    

    public Connect4Client(String hostname, int port) throws IOException {
        socket = new Socket(hostname, port);
    }

    public void sendMessage(String type, int move) throws IOException{
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        Message m = new Message(type, move);
        outputStream.writeObject(m);
        outputStream.flush();
    }

    public Message receiveMessage() throws IOException, ClassNotFoundException{
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
        return (Message) inputStream.readObject();
    }

    public void play() throws IOException, ClassNotFoundException {
 


        /*
        // Receive a message
        Message receivedMessage = (Message) inputStream.readObject();
        System.out.println(receivedMessage.getType());

        // Send a message
        Message message = new Message("Hello, server!", 8);
        outputStream.writeObject(message);
        outputStream.flush();*/
    }

    public static void main(String args[]) throws IOException, ClassNotFoundException{
        Connect4Client client = new Connect4Client("localhost", 8000);
        client.play();
    }
}

