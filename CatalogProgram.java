
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Thread;


public class CatalogProgram {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        printMenu();
       
        int numChoice = 0;
        boolean exitProgram = false;

        do {
            try {
                System.out.println("\nEnter your choice: ");
                numChoice = scr.nextInt();
                if (numChoice < 1 || numChoice > 11)
                    System.out.println("\nInvalid Selection. Please Choose Again (1-11)");
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Selection. Please Choose Again (1-11)");
                scr.next();
                numChoice = 0;
            }    
        
        } while ((exitProgram == false)); 

        switch (numChoice) {
            case 1:
                System.out.println("Enter item name to search");
                break;
            case 2:
                System.out.println("Booting Add new item");
                break;
            case 3:
                System.out.println("Booting Remove Item");
                break;        
            case 4:
                System.out.println("Booting Edit Items");    
                break;
            case 5:
                System.out.println("Booting Add new customer");
                break;
            case 6:
                System.out.println("Booting Remove Customer");
                break;
            case 7:
                System.out.println("Booting Edit Customers");
                break;       
            case 8:
                System.out.println("Booting Upload fIles");
                break;
            case 9:
                System.out.println("Printing current catalog");
                
                break;
            case 10:
                System.out.println("Printing current customer logs");
                break;
            case 11:
                System.out.println("Exiting");
                exitProgram = true;
                break;        
            default:
                System.out.println("Invalid Selection. Bypassed Input Validation. Going back to Menu");
                //System.exit(InputMismatchException);
                break;
        }
        scr.close();

        if (exitProgram){
            System.exit(0);
        }
        
    }
    

    public static void printMenu(){
        System.out.println("Lopez Urban Farm Catalog");
        System.out.println("\nMENU - Enter a number to proceed");
        System.out.println("\n1 - Search Catalog");
        System.out.println("\n2 - Add new item");
        System.out.println("\n3 - Remove item");
        System.out.println("\n4 - Edit Items");
        System.out.println("\n5 - Add new customer");
        System.out.println("\n6 - Remove customer");
        System.out.println("\n7 - Edit customer");
        System.out.println("\n8 - Upload files");
        System.out.println("\n9 - View current catalog");
        System.out.println("\n10 - View customer logs");
        System.out.println("\n11 - Exit Program");

    }
    
}
