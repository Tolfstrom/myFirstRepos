/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbased;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Main {

    
    

    public Main() {
        
    }

    public static void main(String[] args) {
        Descriptions.initialize();
        int playerInput;
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        

        while (!exit) {

            do {
                System.out.println(" ======================= ");
                System.out.println("|                       |");
                System.out.println("|  Welcome to TxtBased  |");
                System.out.println("|  -------------------  |");
                System.out.println("|                       |");
                System.out.println("|   1. Start new game   |");
                System.out.println("|   2. Load last game   |");
                System.out.println("|       3. Quit         |");
                System.out.println("|                       |");
                System.out.println("|                       |");
                System.out.println("|                       |");
                System.out.println(" ======================= ");
                System.out.println("");
                System.out.println("");
                System.out.print("Your choice: ");
                
                try{
                playerInput = sc.nextInt();
                if (playerInput == 1) {
                    TextBased run = new TextBased(false);
                }
                if (playerInput == 2) {
                    TextBased run = new TextBased(true);
                }
                if (playerInput == 3){
                    System.out.println("Goodbye!!");
                    exit = true;
                }
                
            } 
                
                catch(InputMismatchException ime){
                    System.out.println("Strange Input. Try again.");
                    sc.nextLine();
                    System.out.println(ime.getCause());
                    
                    
                }}
                
                while (!exit);
        }

    }

}
