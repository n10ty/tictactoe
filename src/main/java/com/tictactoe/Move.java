package com.tictactoe;

public class Move {
    private Side side;
    private int cellNumber;

    private Move(Side side, int cellNumber) {
        this.side = side;
        this.cellNumber = cellNumber;
    }

    public Side getSide() {
        return side;
    }

    public int getCellNumber() {
        return cellNumber;
    }

    public static Move create(Side side, int cellNumber) {
        return new Move(side, cellNumber);
    }
}
