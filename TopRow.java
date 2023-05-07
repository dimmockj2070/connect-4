import java.awt.Color;
import java.awt.Graphics;

public class TopRow { //the chip you are about to place
    private int width;
    private int chipPos;
    private boolean isBlue;
    private Board b;

    public TopRow(int startPos, boolean isB, Board board){
        b = board;
        width = board.getWidth();
        if(startPos >= width){
            startPos = width - 1;
        }else if(startPos < 0){
            startPos = 0;
        }
        chipPos = 0;
        isBlue = isB;
    }

    public void moveLeft(){
        if(chipPos > 0){
            chipPos--;
        }
    }

    public void moveRight(){
        if(chipPos < width - 1){
            chipPos++;
        }
    }

    public void place(){
        int state;
        if(isBlue){
            state = 1;
        }else{
            state = 2;
        }
        b.placePiece(chipPos, state);
        isBlue = !isBlue;
    }

    public void draw(Graphics window, int w, int h){
        Color chipColor;
        if(isBlue){
            chipColor = Color.blue;
        }else{
            chipColor = Color.red;
        }
        window.setColor(chipColor);
        window.fillOval(b.calcXPos(chipPos, w), b.calcYPos(-1, h), b.calcChipWidth(w), b.calcChipHeight(h));

    }
}