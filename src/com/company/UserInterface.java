/** UserInterface class is responsible for handling user input and outputting game logic decisions.
 * UI contains a GameLogic object alongside several functions that are used to get and output data from GameLogic.
 * UI also contains a Scanner within a function which is used for getting user input and processing it for GameLogic.
 * UI additionally has a character array which is used for game board row designation.
*/
package com.company;

import java.util.Scanner;

public class UserInterface {
    public static final String INTRODUCTION = """
            ----------------------------
            Welcome to Fortress Defense!
            by Kian and Sasha
            ----------------------------
            """;
    private final GameLogic game;

    char[] rowLetter = new char[10];

    public UserInterface(GameLogic game) {
        this.game = game;
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
        char[][] gameBoard = game.getUIGrid();
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

    public void printTankArray() {
        int i = 1;
        int totalTankAttackDMG = 0;
        var tankList = game.getTankArray();
        for (Tank tank : game.getTankArray()) {
            tank.calcTankHP();
            tank.calcTankAttackDMG();
            totalTankAttackDMG = totalTankAttackDMG + tank.getTankAttackDMG();
            if (tank.getTankHealth() != 0) {
                System.out.println("Alive tank #" + i + " of " + tankList.size() + " shot you for " + tank.getTankAttackDMG());
            }
            i++;
        }
        damageFortressHealth(totalTankAttackDMG);
    }

    private void damageFortressHealth(int totalTankAttackDamage) {
        int currentFortressHealth = game.getFortressHealth();
        int newFortressHealth = currentFortressHealth - totalTankAttackDamage;
        game.setFortressHealth(newFortressHealth);
    }

    public void printFortressHealth() {
        System.out.println("Fortress health remaining: " + game.getFortressHealth());
    }
    public int convertUserXToGrid(char usr){
        for(int i = 0; i < 10; i++){
            if(rowLetter[i] == Character.toUpperCase(usr)){
                return i;
            }
        }
        return -1; //invalid input
    }
    public void run(Boolean cheat){
        if(cheat){
            printGameBoardCheat();
            printFortressHealth();
            System.out.println("(Lower case tank letters are where you shot.)");
            System.out.println("\n");
            System.out.println("There are " + game.getNumOfTanks() + " tanks approaching.");
            System.out.println(INTRODUCTION);

        }
        while(!game.getGameFinished()){
            printGameBoard();
            printFortressHealth();
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
        if(game.getUserTheWinner()){
            System.out.println("Congratulations! You have defended the fortress!");
        }
        else{
            System.out.println("Oh no! The tanks have destroyed the fortress!" );
        }
        printGameBoardCheat();
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
    }

    public int[] getUserInput() {
        System.out.println("Enter your move: ");
        Scanner scan = new Scanner(System.in);
        String userCord = scan.next();
        while(userCord.length() > 3 || userCord.length() < 2){
            System.out.println("Bad input");
            scan = new Scanner(System.in);
            userCord = scan.next();
            userCord.trim();
        }
        while( userCord.length() == 3 && !userCord.substring(1,3).equalsIgnoreCase("10")){
            System.out.println("Bad input");
            scan = new Scanner(System.in);
            userCord = scan.next();
            userCord.trim();
        }
        int x = convertUserXToGrid(userCord.charAt(0));
        int y = Character.getNumericValue(userCord.charAt(1)) - 1;

        if(userCord.length() == 3 && userCord.substring(1,3).equalsIgnoreCase("10")){
            y = 9;
        }

        while(x < 0 || y < 0 || x > 9 || y > 9){
            System.out.println("Bad input");
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
