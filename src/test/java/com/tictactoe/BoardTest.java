package com.tictactoe;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void empty() {
        Board board = Board.empty();

        assertTrue(board.getCells()[0].isEmpty());
        assertTrue(board.getCells()[board.getCells().length-1].isEmpty());
    }

    @Test
    public void xToBinary() {
        Board board = Board.empty();
        board.move(Move.create(Side.X, 3));
        board.move(Move.create(Side.X, 4));
        board.move(Move.create(Side.X, 7));


        assertEquals("001100100", board.XToBinary());
    }

    @Test
    public void oToBinary() {
        Board board = Board.empty();
        board.move(Move.create(Side.O, 1));
        board.move(Move.create(Side.O, 5));
        board.move(Move.create(Side.O, 9));


        assertEquals("100010001", board.OToBinary());
    }

    @Test
    public void isXWonSuccessfully() {
        Board board = Board.empty();
        board.move(Move.create(Side.X, 1));
        board.move(Move.create(Side.X, 5));
        board.move(Move.create(Side.X, 9));

        assertTrue(board.isXWon());
    }

    @Test
    public void isXNotWon() {
        Board board = Board.empty();
        board.move(Move.create(Side.X, 2));
        board.move(Move.create(Side.X, 5));
        board.move(Move.create(Side.X, 9));

        assertFalse(board.isXWon());
    }
}