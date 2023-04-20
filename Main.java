public class Main{
    public static void main(String[] args){
        Board b = new Board(7, 8);
        int x = b.getPositionStatus(1, 1);
        System.out.println(x);
        b.setPositionStatus(3, 6, 1);
        System.out.println(b.getPositionStatus(3, 6));
        b.placePiece(3, 2); 
        System.out.println(b.getPositionStatus(3, 5));
        b.printBoard();
        System.out.println(b.checkWin(2));
        b.placePiece(0, 2);
        b.placePiece(1, 2);
        b.placePiece(2, 2);
        b.printBoard();
        System.out.println(b.checkWin(2));
    }
}