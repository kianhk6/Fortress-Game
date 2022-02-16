package com.company;
import java.util.ArrayList;
public class Tank {
    private int tankHP;
    private int tankDMG;
    ArrayList<Cell> tankCells = new ArrayList<>();

    //Tank

    public Tank() {
        //Tank Constructor
    }

    public void calcTankDMG() {
        switch (tankHP) {
            case 0:
                tankDMG = 0;
                break;

            case 1:
                tankDMG = 1;
                break;

            case 2:
                tankDMG = 2;
                break;

            case 3:
                tankDMG = 3;
                break;

            case 4:
                tankDMG = 5;
                break;

            case 5:
                tankDMG = 20;
                break;

            default:
                assert tankCells.size() < 6;
        }
    }

    public void calcTankHP() {
        int aliveCells = 0;
        for (Cell cell : tankCells) {
            if (!cell.isHit()) {
                aliveCells++;
            }
        }
        tankHP = aliveCells;
    }

    public int getTankHP() {
        return tankHP;
    }

    public int getTankDMG() {
        return tankDMG;
    }
}
