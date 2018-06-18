package com.tictactoe;

class Cell {
    private Side side;

    private Cell(Side side) {
        this.side = side;
    }

    private Cell() {
    }

    static Cell X() {
        return new Cell(Side.X);
    }

    static Cell O() {
        return new Cell(Side.O);
    }

    static Cell empty() {
        return new Cell();
    }

    boolean isEmpty() {
        return side == null;
    }

    Side getSide() {
        return side;
    }

    public boolean isX() {
        return side.equals(Side.X);
    }

    public boolean isO() {
        return side.equals(Side.O);
    }

    public String getPrintableSide() {
        if (isEmpty()) {
            return " ";
        }

        return side.toString();
    }

    public void mark(Side side) {
        this.side = side;
    }

    boolean isNotEmpty() {
        return !isEmpty();
    }
}
