
import java.util.InputMismatchException;
import java.util.Scanner;


public class CatalogProgram {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        printMenu();
       
        int numChoice = 0;

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
        
        } while ((numChoice < 1 || numChoice > 12)); 

        switch (numChoice) {
            case 1:
                System.out.println("Booting Search");
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
                System.out.println("Enter customer name to add to queue");
            case 12:
                System.out.println("Removing first customer in queue");
                System.exit(0);
                break;
            case 13:
                System.out.println("Printing next customer");
            case 14:
                System.out.println("Exiting");
                System.exit(0);
                break;           
            default:
                System.out.println("Invalid Selection. Bypassed Input Validation. Exiting Program");
                //System.exit(InputMismatchException);
                break;
        }
        scr.close();
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
        System.out.println("\n11 - Add customer to queue");
        System.out.println("\n12 - Remove customer from queue");
        System.out.println("\n13 -  View next customer in queue");
        System.out.println("\n14 - Exit Program");

    }
}
