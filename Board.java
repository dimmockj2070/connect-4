import java.awt.Color;
import java.awt.Graphics;

public class Board {
    private int[][] positions;
    
    private int width;
    private int height;
    private static final boolean DEBUG = false;
    public Board(int w, int h){
        positions = new int[h][w];
        width = w;
        height = h;
    }
    public int getPositionStatus(int x, int y){
        return positions[y][x];
    }
    public void setPositionStatus(int x, int y, int state){
        positions[y][x] = state;
    }
    public void placePiece(int x, int state){
        if(x >= width){
            return;
        }
        for(int i = height-1; i >= 0; i--){
            if(getPositionStatus(x, i) == 0){
                setPositionStatus(x, i, state);
                return;
            }
        }
    }
    private boolean isValidPos(int x, int y){
        return x >= 0 && y >= 0 && x < width && y < height;
    }
    public boolean checkWin(int state){
        for(int col = 0; col < width; col++){
            for(int row = 0; row < height; row++){
                if(getPositionStatus(col, row) == state){
                    if(DEBUG){
                        System.out.println("Case 1 " + col + "," + row);
                    }
                    int curTestX = col - 1;
                    int curTestY = row - 1;
                    if(isValidPos(curTestX, curTestY) && getPositionStatus(curTestX, curTestY) == state){
                        curTestX--;
                        curTestY--;
                        if(DEBUG){
                            System.out.println("Case 2 " + curTestX + "," + curTestY);
                        }
                        if(isValidPos(curTestX, curTestY) && getPositionStatus(curTestX, curTestY) == state){
                            curTestX--;
                            curTestY--;
                            if(DEBUG){
                                System.out.println("Case 3 " + curTestX + "," + curTestY);
                            }
                            if(isValidPos(curTestX, curTestY) && getPositionStatus(curTestX, curTestY) == state){
                                if(DEBUG){
                                    System.out.println("Case 4 " + curTestX + "," + curTestY);
                                }
                                return true;
                            }
                        }
                    }
                    curTestX = col;
                    curTestY = row - 1;
                    if(isValidPos(curTestX, curTestY) && getPositionStatus(curTestX, curTestY) == state){
                        curTestY--;
                        if(DEBUG){
                            System.out.println("Case 2 " + curTestX + "," + curTestY);
                        }
                        if(isValidPos(curTestX, curTestY) && getPositionStatus(curTestX, curTestY) == state){
                            curTestY--;
                            if(DEBUG){
                                System.out.println("Case 3 " + curTestX + "," + curTestY);
                            }
                            if(isValidPos(curTestX, curTestY) && getPositionStatus(curTestX, curTestY) == state){
                                if(DEBUG){
                                    System.out.println("Case 4 " + curTestX + "," + curTestY);
                                }
                                return true;
                            }
                        }
                    }
                    curTestX = col + 1;
                    curTestY = row - 1;
                    if(isValidPos(curTestX, curTestY) && getPositionStatus(curTestX, curTestY) == state){
                        curTestX++;
                        curTestY++;
                        if(DEBUG){
                            System.out.println("Case 2 " + curTestX + "," + curTestY);
                        }
                        if(isValidPos(curTestX, curTestY) && getPositionStatus(curTestX, curTestY) == state){
                            curTestX++;
                            curTestY++;
                            if(DEBUG){
                                System.out.println("Case 3 " + curTestX + "," + curTestY);
                            }
                            if(isValidPos(curTestX, curTestY) && getPositionStatus(curTestX, curTestY) == state){
                                if(DEBUG){
                                    System.out.println("Case 4 " + curTestX + "," + curTestY);
                                }
                                return true;
                            }
                        }
                    }
                    curTestX = col + 1;
                    curTestY = row;
                    if(isValidPos(curTestX, curTestY) && getPositionStatus(curTestX, curTestY) == state){
                        curTestX++;
                        if(isValidPos(curTestX, curTestY) && getPositionStatus(curTestX, curTestY) == state){
                            curTestX++;
                            if(isValidPos(curTestX, curTestY) && getPositionStatus(curTestX, curTestY) == state){
                                return true;
                            }
                        }
                    }
                }
            }
        }
    return false;
    }
    public int[][] getBoardStatus(){
        return positions;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public void printBoard(){
        for(int[] row : positions){
            String theRow = "";
            for(int i : row){
                theRow += i + " ";
            }
            System.out.println(theRow);
        }
    }
    public void drawBoard(Graphics window, int graphWidth, int graphHeight){
        window.setColor(Color.white);
        window.fillRect(0, 0, graphWidth, graphHeight);
        window.setColor(Color.yellow);
        window.fillRect(0, calcYPos(0, graphHeight), graphWidth, graphHeight - calcYPos(0, graphHeight));
        for(int x = 0; x < positions[0].length; x++){
            for(int y = 0; y < positions.length; y++){
                drawChip(window, x, y, graphWidth, graphHeight);
            }
        }
    }
    private void drawChip(Graphics window, int x, int y, int w, int h){
        int state = positions[y][x];
        if(state == 0){
            window.setColor(Color.white);
        }else if(state == 1){
            window.setColor(Color.blue);
        }else{
            window.setColor(Color.red);
        }
        window.fillOval(calcXPos(x, w), calcYPos(y, h), calcChipWidth(w), calcChipHeight(h));
    }
    public int calcXPos(int x, int w){
        return w / positions[0].length * x;
    }
    public int calcChipWidth(int w){
        return w / positions[0].length * 5 / 6;
    }
    public int calcYPos(int y, int h){
        return h / (positions.length + 1) * (y + 1) * 19 / 20;
    }
    public int calcChipHeight(int h){
        return h / (positions.length + 1) * 5 / 6;
    }
}
