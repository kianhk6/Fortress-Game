package com.company;

public class UserInterface {
    private GameLogic game;
    private Boolean cheat;
    char[] rowLetter = new char[10];
    public UserInterface(GameLogic game, boolean cheat){
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
    public void printGameBoard(){
        char[][] gameBoard = cheat ? game.getCheatGrid() : game.getUIGrid();
        System.out.printf("%s", "       ");
        for(int i = 0; i < 10; i++){
            System.out.printf("%d  ", i);
        }
        System.out.println();
        for(int i = 0; i < 10; i++){
            System.out.printf("    %c  ", rowLetter[i]);
            for(int j = 0; j < 10; j++){
                System.out.printf("%c  ", gameBoard[i][j]);
            }
            System.out.println();

        }
    }
}
