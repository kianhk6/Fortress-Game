package com.company;
import com.google.gson.Gson;

public class Main {
    private static boolean IsCheat;

    public static void main(String[] args) {
        Gson gson  = new Gson();

        IsCheat = false;
        int numOfTanks = 5;
        if(args.length != 0){
            numOfTanks = Character.getNumericValue(args[0].charAt(0));
            if(numOfTanks == -1){
                numOfTanks = 5;
            }
            if(args[1].equals("--cheat")){
                IsCheat = true;
            }
        }


        Grid grid = new Grid();
        GameLogic game = new GameLogic(numOfTanks, grid);
        UserInterface UI = new UserInterface(game);
        UI.run(IsCheat);
    }
}
