package com.company;
//
public class Main {

    public static void main(String[] args) {
        Grid grid = new Grid();
        GameLogic game = new GameLogic(1, grid);
        UserInterface UI = new UserInterface(game, false);
        UI.run();

	// write your code here
        //hi
    }
}
