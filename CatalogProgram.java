
import java.util.Scanner;


public class CatalogProgram {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

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

        int numChoice = scr.nextInt();

        while (numChoice < 1 || numChoice > 11){
            System.out.println("Invalid Selection. Please Choose Again (1-10)");
            numChoice = scr.nextInt();
        }

        scr.close();

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
                System.out.println("Exiting");
                System.exit(0);
                break;        
            default:
                System.out.println("Invalid Selection. Bypassed Input Validation. Exiting Program");
                //System.exit(InputMismatchException);
                break;
        }
    }
}
