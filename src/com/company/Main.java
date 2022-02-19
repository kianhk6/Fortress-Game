package com.company;
//
public class Main {

    public static void main(String[] args) {
        Grid grid = new Grid();
        GameLogic game = new GameLogic(10, grid);
        UserInterface UI = new UserInterface(game);
        UI.run(true);

	// write your code here
        //hi
    }
}
