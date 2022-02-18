package com.company;

public class Grid {
    //Grid
    Cell[][] grid = new Cell[10][10];

    public Grid() {
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                grid[i][j] = new Cell(i, j);
                System.out.println(grid[i][j].getX()+ "," + grid[i][j].getY());
            }
        }
    }

    public boolean isCellTank(int x, int y) {
        return grid[x][y].getIsTank();
    }
    public int getWhichTank(int x, int y) {
        return grid[x][y].getWhichTank();
    }
    public void setWhichTank(int x, int y, int tankNum){
        grid[x][y].setWhichTank(tankNum);
    }
    public boolean isCellHit(int x, int y) {
        return grid[x][y].getIsHit();
    }

    public void setTank(int x, int y) {
        Cell cell = grid[x][y];
        cell.setTank();
    }

    public void setHit(int x, int y) {
        Cell cell = grid[x][y];
        cell.setHit();
    }

    public Cell getCell(int x, int y) {
        return grid[x][y];
    }

    public Cell[][] getGrid() {
        return grid;
    }
}
