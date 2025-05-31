import game.CandyCrush;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CandyCrush candyCrush  = new CandyCrush();
        candyCrush.fill();

        Scanner sc = new Scanner(System.in);

        int row,col;
        String direction;
        
        while(candyCrush.isRunning()){
            candyCrush.printBoard();
            
            while(true){
            
                System.out.println("Enter in x coordinate: ");
                row = sc.nextInt();
                System.out.println("Enter in y coordinate: ");
                col = sc.nextInt();
                
                if(!candyCrush.validateCoords(row, col)) {
                    System.out.println("You entered in invalid coordinates!");
                    continue;
                }
                
                break;
            }
            
            sc.nextLine();
            
            while(true) {
            
                System.out.println("Do you want to swap up, down, left or right");
                String choice = sc.nextLine();
                
                if(choice.equalsIgnoreCase("up") || choice.equalsIgnoreCase("left") || 
                   choice.equalsIgnoreCase("right") || choice.equalsIgnoreCase("down")) {
                     direction = choice.toLowerCase();
                     break;  
                }else{
                    System.out.println("Enter in a valid direction!");
                }
               
            }
            
            candyCrush.printBoard();
            System.out.println("\nPress enter to see swap");
            sc.nextLine();
            candyCrush.swap(row, col, direction);
            candyCrush.printBoard();
            System.out.println("\nPress enter to see crush");
            sc.nextLine();
            candyCrush.crush();
            candyCrush.printBoard();
            System.out.println("\nPress enter to see gravity");
            sc.nextLine();
            candyCrush.gravity();
            candyCrush.printBoard();
            System.out.println("\nPress enter to fill");
            sc.nextLine();
            candyCrush.fill();
        }
    }

}
