package com.company;

public class Cell {
    //Cell
    private boolean isTank;
    private boolean isHit;
    private int x;
    private int y;

    // Cell Constructor, sets the coordinates and booleans
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        isTank = false;
        isHit = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean getIsTank() {
        return isTank;
    }

    public boolean getIsHit() {
        return isHit;
    }

    // + setTank():void
    public void setTank() {
        isTank = true;

    }

    // +gotHit(object:cell):void
    public void cellHit() {
        isHit = true;

    }

    // + setX(number:integer):void
    public void setX(int newX) {
        x = newX;

    }

    // + setY(number:integer):void
    public void setY(int newY) {
        y = newY;

    }
}
