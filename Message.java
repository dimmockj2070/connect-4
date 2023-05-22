import java.io.Serializable;

public class Message implements Serializable {
    private String type;
    private int move;

    public Message(String type, int move) {
        this.type = type;
        this.move = move;
    }

    public String getType() {
        return type;
    }

    public int getMove() {
        return move;
    }

    public String toString(){
        return type + " " + move;
    }
}
