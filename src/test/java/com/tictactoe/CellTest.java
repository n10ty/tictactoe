package com.tictactoe;

import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {

    @Test
    public void testIsEmpty() {
        Cell cell = Cell.empty();
        assertTrue(cell.isEmpty());
    }

    @Test
    public void testIsNonEmpty() {
        Cell cell = Cell.X();
        assertFalse(cell.isEmpty());
    }

    @Test
    public void isX() {
        Cell cell = Cell.X();
        assertTrue(cell.isX());
    }

    @Test
    public void isO() {
        Cell cell = Cell.O();
        assertTrue(cell.isO());
    }
}