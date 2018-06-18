package com.tictactoe;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Board {
    private String[] wonConditions = new String []{
            "100100100",
            "010010010",
            "001001001",
            "111000000",
            "000111000",
            "000000111",
            "100010001",
            "001010100",
    };

    static final int BOARD_WIDTH = 3;
    private Cell[] cells;

    private Board(int width) {
        cells = new Cell[width * width];
        for (int i = 0; i < cells.length; i++) {
            cells[i] = Cell.empty();
        }
    }

    public static Board empty() {
        return new Board(BOARD_WIDTH);
    }

    public boolean somePlayerWon() {
        return isOWon() || isXWon();
    }

    public boolean hasNextMove() {
        return hasEmptyCell();
    }

    public void move(Move move) {
        Cell cell = cells[move.getCellNumber() - 1];
        cell.mark(move.getSide());
    }

    Cell[] getCells() {
        return cells;
    }

    /**
     * @return boolean
     */
    boolean isXWon() {
        return this.metAnyWonCondition(XToBinary());
    }

    /**
     * @return boolean
     */
    boolean isOWon() {
        return this.metAnyWonCondition(OToBinary());
    }

    /**
     * Return binary number where all X cells marks as 1
     *
     * @return String
     */
    String XToBinary() {
        return
            Stream.of(cells)
                .map(cell -> (cell.isNotEmpty() && cell.isX() ? "1" : "0"))
                .collect(Collectors.joining());
    }

    /**
     * Return binary number where all O cells marks as 1
     *
     * @return String
     */
    String OToBinary() {
        return
            Stream.of(cells)
                .map(cell -> (cell.isNotEmpty() && cell.isO() ? "1" : "0"))
                .collect(Collectors.joining());
    }

    private boolean hasEmptyCell() {
        return Arrays.stream(cells).anyMatch(Cell::isEmpty);
    }

    private boolean metAnyWonCondition(String boardBinaryPresentation) {
        return Stream.of(wonConditions)
                .anyMatch(wonCondition -> (toInt(wonCondition) & toInt(boardBinaryPresentation)) == toInt(wonCondition));
    }

    private int toInt(String string) {
        return Integer.parseInt(string, 2);
    }
}
