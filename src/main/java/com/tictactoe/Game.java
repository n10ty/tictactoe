package com.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Game {
    private Board board;
    private BoardPrinter printer;
    private Side nextMoveSide;

    public Game() {
        printer = new BoardPrinter();
        nextMoveSide = Side.X;
    }

    public void start() throws Exception {
        board = Board.empty();
        while (isNotFinished()) {
            drawBoard();
            int cellNumber = promptMove();
            board.move(Move.create(nextMoveSide, cellNumber));
            changeSide();
        }
        if (board.somePlayerWon()) {
            changeSide(); //to print current player side
            drawBoard();
            System.out.println(String.format("Player %s won!", nextMoveSide.toString()));
        } else {
            System.out.println("Draw!");
        }

    }

    private boolean isNotFinished() {
        return !board.somePlayerWon() && board.hasNextMove();
    }

    private int promptMove() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter move:");
        try{
            return Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe){
            System.err.println("Invalid Format!");
        }

        return 0;
    }

    private void drawBoard(BoardPrinter printer) throws Exception {
        printer.print(board);
    }

    private void drawBoard() throws Exception {
        drawBoard(printer);
    }

    private void changeSide() {
        nextMoveSide = nextMoveSide.equals(Side.O) ? Side.X : Side.O;
    }
}
