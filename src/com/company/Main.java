/** Main Class
 * The main class initiates the fortress defense game, and is where the JAR file runs from.
 * It accepts up to two arguments by the user from the terminal, being the number of tanks and whether cheat is enabled.
 * It contains a Grid object, a GameLogic object, and a UI object.
 */

package com.company;

import com.google.gson.Gson;

//Type  java -jar out/artifacts/game_jar/game.jar [numTanks] [cheat] to play!

public class Main {
    private static boolean IsCheat;

    public static void main(String[] args) {

        System.out.println(args.length);
        Gson gson = new Gson();

        IsCheat = false;
        int numOfTanks = 5;
        if(args.length != 0) {
            numOfTanks = (Integer.parseInt(args[0]));
            if(numOfTanks == -1){
                numOfTanks = 5;
            }

            if (numOfTanks > 10) {
                System.out.println("A maximum of ten tanks can be deployed. Please try again.");
                System.exit(-1);
            }

            if (args.length == 2) {
                if (args[1].equals("--cheat")) {
                    IsCheat = true;
                }

                if (!args[1].equals("--cheat")){
                    System.out.println("--cheat is the only valid second argument, all others are ignored.");
                    System.exit(-1);
                }
            }
        } if (args.length > 2) {
            System.out.println("Do not provide more than two arguments, only the first two will be read.");
            System.exit(-1);
        }

        Grid grid = new Grid();
        GameLogic game = new GameLogic(numOfTanks, grid);
        UserInterface UI = new UserInterface(game);
        UI.run(IsCheat);
    }
}
