package com.company;

import java.util.Locale;
import java.util.Scanner;

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
    }
    public int convertUserXToGrid(char usr){
        for(int i = 0; i < 10; i++){
            if(rowLetter[i] == Character.toUpperCase(usr)){
                return i;
            }
        }
        return -1; //invalid input

    }
    public int[] getUserInput() {
        Scanner scan = new Scanner(System.in);
        String userCord = scan.next();
        while(userCord.length() > 2 || userCord.length() < 2){
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
