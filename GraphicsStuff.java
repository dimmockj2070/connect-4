import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;

public class GraphicsStuff extends Canvas implements KeyListener, Runnable {
    private Board b;
    private int pixWidth;
    private int pixHeight;
    private BufferedImage back;
    private boolean[] keys;
    private TopRow top;
    private boolean redWin;
    private boolean blueWin;

    public GraphicsStuff(int w, int h, int pw, int ph){
        pixWidth = pw;
        pixHeight = ph;
        b = new Board(w, h);
        keys = new boolean[3];
        top = new TopRow(0, true, b);

        setBackground(Color.WHITE);
        setVisible(true);

        new Thread(this).start();
        addKeyListener(this);
    }

    public void update(Graphics window){
        paint(window);
    }

    public void paint(Graphics window){

        Graphics2D twoDGraph = (Graphics2D)window;

        if (back==null)
            back = (BufferedImage) (createImage(getWidth(), getHeight()));

        Graphics graphToBack = back.createGraphics();
        b.drawBoard(graphToBack, pixWidth, pixHeight);

        redWin = b.checkWin(2);
        blueWin = b.checkWin(1);
        if(!redWin && !blueWin){
            if(keys[0]){
                top.moveLeft();
                keys[0] = false;
            }else if (keys[1]){
                top.moveRight();
                keys[1] = false;
            }else if (keys[2]){
                top.place();
                keys[2] = false;
            }
            top.draw(graphToBack, pixWidth, pixHeight);
        }else if(blueWin){
            //System.out.println("blue win");
            graphToBack.setColor(Color.blue);
            graphToBack.drawString("Blue wins", 10, 10);
        }else{
            //System.out.println("red win");
            graphToBack.setColor(Color.red);
            graphToBack.drawString("Red wins!", 10, 10);
        }

        twoDGraph.drawImage(back, null, 0, 0);
    }

    public void keyTyped(KeyEvent e){
        switch(toLowerCase(e.getKeyChar())){
            case 'a' : keys[0]=true; break;
            case 'd' : keys[1]=true; break;
            case ' ' : keys[2]=true; break;
        }
    }

    public void keyPressed(KeyEvent e){

    }

    public void keyReleased(KeyEvent e){}
    public void run(){
        try{
            while(true){
                Thread.currentThread().sleep(8);
                repaint();
            }
        }catch(Exception e){
        }
    }
}
