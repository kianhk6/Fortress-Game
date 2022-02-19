package com.company;

//
public class Main {
    private static boolean IsCheat;

    public static void main(String[] args) {
        IsCheat = false;
        int numOfTanks = Character.getNumericValue(args[0].charAt(0));
        if(numOfTanks == -1){
            numOfTanks = 5;
        }
        if(args[1].equals("--cheat")){
            IsCheat = true;
        }

        Grid grid = new Grid();
        GameLogic game = new GameLogic(numOfTanks, grid);
        UserInterface UI = new UserInterface(game);
        UI.run(IsCheat);

	// write your code here
        //hi
    }
}
