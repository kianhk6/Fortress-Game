package com.company;
//
public class Main {

    public static void main(String[] args) {
        Grid grid = new Grid();
        GameLogic game = new GameLogic(5, grid);
        game.generateTanks();
        UserInterface UI = new UserInterface(game, true);
        UI.printGameBoard();

	// write your code here
        //hi
    }
}
