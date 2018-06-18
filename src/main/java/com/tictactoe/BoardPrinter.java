package com.tictactoe;

public class BoardPrinter {
    public void print(Board board) throws Exception {
        if (board == null) {
            throw new Exception("Can't print nullable board.");
        }

        Cell[] cells = board.getCells();

        System.out.println("+---+---+---+");
        System.out.println("| " + cells[0].getPrintableSide() + " | " + cells[1].getPrintableSide() + " | " + cells[2].getPrintableSide() + " |");
        System.out.println("+---+---+---+");
        System.out.println("| " + cells[3].getPrintableSide() + " | " + cells[4].getPrintableSide() + " | " + cells[5].getPrintableSide() + " |");
        System.out.println("+---+---+---+");
        System.out.println("| " + cells[6].getPrintableSide() + " | " + cells[7].getPrintableSide() + " | " + cells[8].getPrintableSide() + " |");
        System.out.println("+---+---+---+");
    }
}
