package com.company;

public class Grid {
    //Grid
    Cell[][] grid = new Cell[10][10];

    public Grid() {
    }

    public void grid() {
        //Not sure what this does
    }

    public boolean isCellTank(int x, int y) {
        return grid[x][y].isTank();
    }

    public boolean isCellHit(int x, int y) {
        return grid[x][y].isHit();
    }

    public void setTank(int x, int y) {
        Cell cell = grid[x][y];
        cell.setTank();
    }

    public void cellHit(int x, int y) {
        Cell cell = grid[x][y];
        cell.cellHit();
    }

    public Cell getCell(int x, int y) {
        return grid[x][y];
    }
}
