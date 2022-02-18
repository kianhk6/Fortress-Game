package com.company;
//
public class Main {

    public static void main(String[] args) {
        Grid kian = new Grid();

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++ ){
                System.out.println( "x: " + kian.isCellHit(i, j) + " y: " + kian.isCellTank(i, j) +'\n'  );
            }
        }
	// write your code here
        //hi
    }
}
