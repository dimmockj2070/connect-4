package com.example;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

public class BoardTest {
    @Test
    public void testMain() {
        Board b = new Board(7, 8);

        int x = b.getPositionStatus(1, 1);
        assertThat(x, is(0));

        b.setPositionStatus(3, 6, 1);
        x = b.getPositionStatus(3, 6);
        assertThat(x, is(1));

        b.placePiece(3, 2);
        x = b.getPositionStatus(3, 7);
        assertThat(x, is(2));

        b.printBoard();

        assertThat(b.checkWin(2), is(false));

        b.placePiece(0, 2);
        b.placePiece(1, 2);
        b.placePiece(2, 2);

        assertThat(b.checkWin(2), is(true));
    }

    @Test
    public void verticalWin() {
        Board b = new Board(4, 4);

        b.placePiece(0, 1);
        b.placePiece(0, 1);
        b.placePiece(0, 1);
        b.placePiece(0, 1);

        assertThat(b.checkWin(1), is(true));
    }

    @Test
    public void columnOverflow() {
        Board b = new Board(4, 4);

        b.placePiece(0, 1);
        b.placePiece(0, 1);
        b.placePiece(0, 1);
        b.placePiece(0, 1);

        // TODO: throw exception?
        b.placePiece(0, 1);
    }
}
