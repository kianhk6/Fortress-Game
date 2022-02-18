package com.company;
import java.util.ArrayList;
public class Tank {
    private int tankHealth;
    private int tankAttackDMG;
    ArrayList<Cell> tankCells = new ArrayList<>();

    //Tank

    public Tank() {
        //Tank Constructor
    }

    public void calcTankAttackDMG() {
        switch (tankHealth) {
            case 0:
                tankAttackDMG = 0;
                break;

            case 1:
                tankAttackDMG = 1;
                break;

            case 2:
                tankAttackDMG = 2;
                break;

            case 3:
                tankAttackDMG = 3;
                break;

            case 4:
                tankAttackDMG = 5;
                break;

            case 5:
                tankAttackDMG = 20;
                break;

            default:
                assert tankCells.size() < 6;
        }
    }

    public void calcTankHP() {
        int aliveCells = 0;
        for (Cell cell : tankCells) {
            if (!cell.getIsHit()) {
                aliveCells++;
            }
        }
        tankHealth = aliveCells;
    }

    public int getTankHealth() {
        return tankHealth;
    }

    public int getTankAttackDMG() {
        return tankAttackDMG;
    }
}
