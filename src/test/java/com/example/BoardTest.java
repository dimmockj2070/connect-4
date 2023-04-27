package com.example;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BoardTest {
    @Test
    public void testMain() {
        Board b = new Board(7, 8);

        int x = b.getPositionStatus(1, 1);
        assertEquals(0, x);

        b.setPositionStatus(3, 6, 1);
        x = b.getPositionStatus(3, 6);
        assertEquals(1, x);

        b.placePiece(3, 2);
        x = b.getPositionStatus(3, 7);
        assertEquals(2, x);

        // b.printBoard();

        assertFalse(b.checkWin(2));

        b.placePiece(0, 2);
        b.placePiece(1, 2);
        b.placePiece(2, 2);

        assertTrue(b.checkWin(2));
    }

    @Test
    public void verticalWin() {
        Board b = new Board(4, 4);

        b.placePiece(0, 1);
        b.placePiece(0, 1);
        b.placePiece(0, 1);
        b.placePiece(0, 1);

        assertTrue(b.checkWin(1));
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
