///William Yang
///11/12/2022
///Assignment 5 Battleship Game

import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;


public class ship {
    public static void main(String[] args) {
        final int SHIP_SIZE = 4; // constant for the size of the ship
        final int DIMENSION = 10; // constant for the size of the board (square) // create the board 
        String[][] base_grid = new String[DIMENSION][DIMENSION]; //this will be the shown grid, where we will be displaying onto the terminal for the user to see
        for (String[] row: base_grid)
            Arrays.fill(row, " ");
        String[][] new_grid = new String[DIMENSION][DIMENSION]; //this will be the hidden grid, where we will keep the ship on and not display to the user
        for (String[] row: new_grid)
            Arrays.fill(row, " ");
        //here will be a while loop to run it again and again
        show_grid(DIMENSION, base_grid);
        set_ship(new_grid, SHIP_SIZE);
        int tries = 0;
        while(check_map(base_grid, DIMENSION, SHIP_SIZE)){
            bomb_map(new_grid, base_grid);
            show_grid(DIMENSION, base_grid);
            tries +=1;
        }
        System.out.println("You took " + tries + " tries");
    }

    public static void show_grid(int DIMENSION, String base_grid[][]){
        System.out.print("  ");
        int a = 0;
        for(int i = 0; i < DIMENSION; i++){
            a = i +65;
            char k = (char) a ;
            System.out.print(k);
        }
        System.out.println();
        for(int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (j == 0)
                    System.out.print(i + "|" + base_grid[i][j]);
                else if (j == base_grid[i].length - 1)
                    System.out.print(base_grid[i][j] + "|" + i);
                else
                    System.out.print(base_grid[i][j]);
            }
            System.out.println();
        }
    }

    public static String[][] set_ship(String new_grid[][], int SHIP_SIZE){
        SHIP_SIZE -= 1;
        Random rand = new Random();
        int x = rand.nextInt(9);
        int y = rand.nextInt(9);
        int z = rand.nextInt(1);// we will assume 0 means that it will be verticle, while 1 means it is horizontal

        if (z == 0 && x < SHIP_SIZE){// we are setting the ship to extend right
            for(int i = 0; i <= SHIP_SIZE; i++){
                new_grid[x][y] = "@";
                x+=1;
            }
        }
        if (z == 0 && x >= SHIP_SIZE){// we are setting the ship to extend left
            for(int i = 0; i <= SHIP_SIZE; i++){
                new_grid[x][y] = "@";
                x-=1;
            }
        }
        if (z == 1 && y < SHIP_SIZE){// we are setting the ship to extend down
            for(int i = 0; i <= SHIP_SIZE; i++){
                new_grid[x][y] = "@";
                y+=1;
            }
        }
        if (z == 1 && y >= SHIP_SIZE){// we are setting the ship to extend up
            for(int i = 0; i <= SHIP_SIZE; i++){
                new_grid[x][y] = "@";
                y-=1;
            }
        }
        return new_grid;
    }

    public static String[][] bomb_map(String new_grid[][], String base_grid[][]){                        //bombing the map while also checking for valid inputs
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the cordinate you want to bomb in uppercase! (Example: A1)");
        String player_input = input.nextLine();                                    //asking for inputs
        if(player_input.length() != 2){                                            //checking if input only holds two values
            System.out.print("Invalid input, try again");
            return new_grid;
        }
        char first_cordinate = player_input.charAt(0);
        char second_cordinate = player_input.charAt(1);
        int ascii_first_cordinate = (int) first_cordinate;
        int second_cordinate_checking = (int) second_cordinate;
        
        if(ascii_first_cordinate <= 64 || ascii_first_cordinate >= 75){           //checking if the first cordinate is valid or not 
            System.out.print("Invalid X input , try again ");
            System.out.println("");
            return base_grid;
        }
        if(second_cordinate_checking < 48 || second_cordinate_checking > 57){                        //checking if the seocnd cordinate is valid or not 
            System.out.print("Invalid Y input, try again ");
            System.out.println("");
            return base_grid;
        }

        second_cordinate_checking = second_cordinate_checking - 48;
        ascii_first_cordinate = ascii_first_cordinate - 65;                             //converting the first cordinate from ascii to a number that can be represented on the map
        if(new_grid[second_cordinate_checking][ascii_first_cordinate].equals("@")){
            base_grid[second_cordinate_checking][ascii_first_cordinate] = "X";                   //if we hit the ship
        }
        else{
            base_grid[second_cordinate_checking][ascii_first_cordinate] = "#";                    //if we did not hit the ship
        }

        return base_grid;
    }

    public static boolean check_map(String base_grid[][], int DIMENSION, int SHIP_SIZE){
        int counter = SHIP_SIZE;
        for(int i = 0; i < DIMENSION; i++){
            for(int j = 0; j < DIMENSION; j++){
                if(base_grid[i][j].equals("X")){
                    counter -= 1;
                };
            }
        }
        if(counter == 0){
            System.out.print("You have won the game! ");
            System.out.println("");
            return false;
        }
        else{
            return true;
        }
    }
}

