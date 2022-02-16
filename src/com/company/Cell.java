package com.company;

public class Cell {
    //Cell
    private boolean isTank;
    private boolean isHit;
    private int x;
    private int y;

    public Cell() {
        // Cell Constructor, not sure what to construct here yet.
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isTank() {
        return isTank;
    }

    public boolean isHit() {
        return isHit;
    }

    public void cellCords(int newX, int newY) {
        setX(newX);
        setY(newY);
        // + cell(x:integer, y:integer):void
    }

    public void setTank(Cell cell) { //This one is different from UML, not sure
        cell.isTank = true;
        // + setTank(tank: all):void
    }
    public void cellHit(Cell cell) {
        cell.isHit = true;
        // +gotHit(object:cell):void
    }

    public void setX(int newX) {
        x = newX;
        // + setX(number:integer):void
    }

    public void setY(int newY) {
        y = newY;
        // + setY(number:integer):void
    }
}
