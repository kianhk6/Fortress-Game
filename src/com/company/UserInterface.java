package com.company;

import java.util.Locale;
import java.util.Scanner;

import java.util.ArrayList;

public class UserInterface {
    private GameLogic game;
    private Boolean cheat;

    char[] rowLetter = new char[10];

    public UserInterface(GameLogic game, boolean cheat) {
        this.game = game;
        this.cheat = cheat;
        rowLetter[0] = 'A';
        rowLetter[1] = 'B';
        rowLetter[2] = 'C';
        rowLetter[3] = 'D';
        rowLetter[4] = 'E';
        rowLetter[5] = 'F';
        rowLetter[6] = 'G';
        rowLetter[7] = 'H';
        rowLetter[8] = 'I';
        rowLetter[9] = 'J';
    }

    public void printGameBoard() {
        char[][] gameBoard = cheat ? game.getCheatGrid() : game.getUIGrid();
        System.out.printf("%s", "       ");
        for (int i = 1; i < 11; i++) {
            System.out.printf("%d  ", i);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.printf("    %c  ", rowLetter[i]);
            for (int j = 0; j < 10; j++) {
                System.out.printf("%c  ", gameBoard[i][j]);
            }
            System.out.println();
        }
        printFortressHealth();
    }

    public void printTankArray() {
        int i = 1;
        int totalTankAttackDMG = 0;
        var tankList = game.getTankArray();
        for (Tank tank : game.getTankArray()) {
            tank.calcTankHP();
            tank.calcTankAttackDMG();
            totalTankAttackDMG = totalTankAttackDMG + tank.getTankAttackDMG();
            System.out.println("Alive tank #" + i + " of " + tankList.size() + " shot you for " + tank.getTankAttackDMG());
            i++;
        }
        damageFortressHealth(totalTankAttackDMG);
    }

    private void damageFortressHealth(int totalTankAttackDamage) {
        int currentFortressHealth = game.getFortressHealth();
        int newFortressHealth = currentFortressHealth - totalTankAttackDamage;
        game.setFortressHealth(newFortressHealth);
        printFortressHealth();
    }

    public void printFortressHealth() {
        System.out.println("Fortress Health remaining: " + game.getFortressHealth());
    }
    public int convertUserXToGrid(char usr){
        for(int i = 0; i < 10; i++){
            if(rowLetter[i] == Character.toUpperCase(usr)){
                return i;
            }
        }
        return -1; //invalid input
    }
    public void run(){
        while(game.getGameFinished()){
            printGameBoardCheat();
                Boolean didHit = game.userTurn(getUserInput());
                if(didHit){
                    System.out.println("HIT!");
                    printTankArray();
                }
                else{
                    System.out.println("Miss.");
                    printTankArray();
                }
        }


    }

    private void printGameBoardCheat() {
        char[][] gameBoard = game.getCheatGrid();
        System.out.printf("%s", "       ");
        for (int i = 1; i < 11; i++) {
            System.out.printf("%d  ", i);
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.printf("    %c  ", rowLetter[i]);
            for (int j = 0; j < 10; j++) {
                System.out.printf("%c  ", gameBoard[i][j]);
            }
            System.out.println();
        }
        printFortressHealth();
    }

    public int[] getUserInput() {
        System.out.println("Enter your move: ");
        Scanner scan = new Scanner(System.in);
        String userCord = scan.next();
        while(userCord.length() != 2){
            System.out.println("input too short");
            scan = new Scanner(System.in);
            userCord = scan.next();
        }
        int x = convertUserXToGrid(userCord.charAt(0));
        int y = Character.getNumericValue(userCord.charAt(1)) - 1;
        while(x < 0 || y < 0 || x > 9 || y > 9){
            System.out.println("please input an correct task, the coordinate is out of bound");
            userCord = scan.next();
            x = convertUserXToGrid(userCord.charAt(0));
            y = Character.getNumericValue(userCord.charAt(1)) - 1;
        }
        int[] coordinates = new int[2];
        coordinates[0] = x;
        coordinates[1] = y;
        return coordinates;
    }
}
