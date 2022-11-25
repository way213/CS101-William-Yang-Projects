///William Yang
///09/22/2022
///Assignment 2 Part 2
///Number System Converter

import java.util.Scanner;
public class Number_System_Converter {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the number system to convert from: bin, or dec, or oct or hex:");
        String base_system = input.nextLine();
        if (!base_system.equals("bin") && !base_system.equals("dec") && !base_system.equals("oct") && !base_system.equals("hex")){
            System.out.println(base_system);
            System.out.println("Invalid System");
            System.exit(0);
        }
        System.out.println("Enter number as a String:");
            String base_num = input.nextLine();

        ///we convert everything we recieve first into decimal form, then convert the number we recieved into the desired form.
        int old_dec = 0;
        char letter;
        int n = 0;
        int base_length = base_num.length();

        if(base_system.equals("bin")){
            for (int i=0; i<base_length; i++){
                letter = base_num.charAt(i);
                n = Character.getNumericValue(letter);
                old_dec += n*Math.pow(2,((base_length-1)-i));
            }
        }
        if(base_system.equals("dec")){
            for (int i=0; i<base_length; i++){
                letter = base_num.charAt(i);
                n = Character.getNumericValue(letter);
                old_dec += n*Math.pow(10,((base_length-1)-i));
            }
        }
        if(base_system.equals("oct")){
            for (int i=0; i<base_length; i++){
                letter = base_num.charAt(i);
                n = Character.getNumericValue(letter);
                old_dec += n*Math.pow(8,((base_length-1)-i));
            }
        }
        if(base_system.equals("hex")){
            for (int i=0; i<base_length; i++){
                letter = base_num.charAt(i);
                n = Character.getNumericValue(letter);
                old_dec += n*Math.pow(16,((base_length-1)-i));
            }
        }

        System.out.println("Enter the name of the number system to convert to: bin, or dec, or oct or hex:");
        String new_system = input.nextLine();;
        if (!new_system.equals("bin") && !new_system.equals("dec") && !new_system.equals("oct") && !new_system.equals("hex")){
            System.out.println("Invalid System");
            System.exit(0);
        }

        int x = 0; ///this is a placeholder for each individual calculation(temporary)
        String new_num = "";
        ///we will try to convert the numbers below to a desired system.

        if(new_system.equals("bin")){
            while(old_dec >= 2){;
                x = old_dec % 2;
                old_dec = old_dec / 2;
                new_num = x + new_num;
                
            }
            if(old_dec < 2){
                new_num = old_dec + new_num;
            }
        }

        if(new_system.equals("dec")){
            while(old_dec >= 10){;
                x = old_dec % 10;
                old_dec = old_dec / 10;
                new_num = x + new_num;
                
            }
            if(old_dec < 10){
                new_num = old_dec + new_num;
            }
        }

        if(new_system.equals("oct")){
            while(old_dec >= 8){;
                x = old_dec % 8;
                old_dec = old_dec / 8;
                new_num = x + new_num;
                
            }
            if(old_dec < 8){
                new_num = old_dec + new_num;
            }
        }

        if(new_system.equals("hex")){
            while(old_dec >= 16){;
                x = old_dec % 16;
                old_dec = old_dec / 16;
                new_num = x + new_num;
                
            }
            if(old_dec < 16){
                new_num = old_dec + new_num;
            }
        }        
        System.out.println("The result is:" + new_num);














    }



}
