import java.util.InputMismatchException;
import java.util.Scanner;


public class CatalogProgram {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        
        ArrayListMethods arrayListMethods = new ArrayListMethods();
        
        CustomerQueue customerQueue = new CustomerQueue();
        	
        boolean exitProgram = false;
                
	printMenu();

	customerQueue.uploadQueueFiles();
	arrayListMethods.uploadArrayFiles();
		
        int numChoice = 0;
        do {
		do {
	        	try {
	                	System.out.println("\nEnter a menu option: ");
	                	numChoice = scr.nextInt();
	                	if (numChoice < 1 || numChoice > 15)
	                    	System.out.println("\nInvalid Selection. Please Choose Again (1-16)");
	            	} catch (InputMismatchException e) {
	                	System.out.println("\nInvalid Selection. Please Choose Again (1-16)");
	                	scr.next();
	                	numChoice = 0;
	            	}    
	        
	        } while ((numChoice < 1 || numChoice > 15)); 

	        switch (numChoice) {
	            case 1:
	                System.out.println("Enter a crop to search for: ");
	                String searchCrop = scr.next();
	                arrayListMethods.searchItem(searchCrop);
	                break;
	            case 2:
	                System.out.println("Enter crop to create a new item or to add to quantity");
	                String addCropName = scr.next();
	                System.out.println("Enter quantity to add of crop");
	                int addCropQuantity = arrayListMethods.inputValidationInt(scr);
					arrayListMethods.checkForResizeCrops();
	                arrayListMethods.addItem(addCropName, addCropQuantity);
	                break;
	            case 3:
	                System.out.println("Enter a crop to remove from its quantity");
	                String removeCropName = scr.next();
	                System.out.println("Enter amount to remove");
	                int removeCropAmount = arrayListMethods.inputValidationInt(scr);
	                arrayListMethods.removeItem(removeCropName, removeCropAmount);
	                break;        
	            case 4:
	                System.out.println("Enter an item to change its name: ");    
	                String itemNameToChange = scr.next();
	                System.out.println("Enter a new name");
	                String newItemName = scr.next();
	                arrayListMethods.editItem(itemNameToChange, newItemName);
	                break;
	            case 5:
	                arrayListMethods.showCatalog();
	                break;
	            case 6:
	            	System.out.println("Enter a customer name to search");
	            	String customerName = scr.next();
	            	arrayListMethods.searchCustomer(customerName);
	                break;
	            case 7:
	                System.out.println("Enter customer name to add their name to the log or to add to their quantity");
	                String addCustomerName = scr.next();
	                System.out.println("Enter amount of crops taken");
	                int addCropTaken = arrayListMethods.inputValidationInt(scr);
	                arrayListMethods.addCustomer(addCustomerName, addCropTaken);
	                break;
	            case 8:
	                System.out.println("Enter a name to completely remove a customer from log");
	                String removeCustomerName = scr.next();
	                arrayListMethods.removeCustomer(removeCustomerName);
	                break;
	            case 9:
	                System.out.println("Enter a customer name to edit their information");
	                String nameToChange = scr.next();
	                String newNameCustomer;
	                int quantityNew;
	                boolean inputValid = false;
	                do {
	                	System.out.println("Do you want to edit their name or quantity?");
		                String decision = scr.next();
		                switch (decision) {
			                case "name":
			                	System.out.println("Enter a new name for the customer");
				                newNameCustomer = scr.next();
				                arrayListMethods.editCustomerName(nameToChange, newNameCustomer);
				                inputValid = true;
				                break;
			                case "Name":
			                	System.out.println("Enter a new name for the customer");
				                newNameCustomer = scr.next();
				                arrayListMethods.editCustomerName(nameToChange, newNameCustomer);
				                inputValid = true;
				                break;
			                case "NAME":
			                	System.out.println("Enter a new name for the customer");
				                newNameCustomer = scr.next();
				                arrayListMethods.editCustomerName(nameToChange, newNameCustomer);
				                inputValid = true;
				                break;
			                case "Quantity":
			                	System.out.println("Enter a new quantity for the customer");
			                	quantityNew = arrayListMethods.inputValidationInt(scr);
			                	arrayListMethods.editCustomerQuantity(nameToChange, quantityNew);
			                	inputValid = true;
				                break;
			                case "quantity":
			                	System.out.println("Enter a new quantity for the customer");
			                	quantityNew = arrayListMethods.inputValidationInt(scr);
			                	arrayListMethods.editCustomerQuantity(nameToChange, quantityNew);
			                	inputValid = true;
				                break;
			                case "QUANTITY":
			                	System.out.println("Enter a new quantity for the customer");
			                	quantityNew = arrayListMethods.inputValidationInt(scr);
			                	arrayListMethods.editCustomerQuantity(nameToChange, quantityNew);
			                	inputValid = true;
				                break;
			               default:
			            	   System.out.println("Invalid option or spelling error (Please use name or quantity only");
		                }
	                } while (inputValid == false);
	                break;       
	            case 10:	
	                arrayListMethods.showCustomerLog();
	                break;
	            case 11:
	                System.out.println("Enter a customer name to add to queue");
	                String queueName = scr.next();
	                customerQueue.addCustomer(queueName);
	                break;
	            case 12:
	                System.out.println("Checking in next customer: " + customerQueue.getNextCustomer());
	                break;
	            case 13:
	            	customerQueue.showQueue();
	                break;
	            case 14:
	            	System.out.println("Save files");
	            	arrayListMethods.saveArrayFiles();
	            	customerQueue.saveQueueFiles();
	            	break;
	            case 15:
	                System.out.println("Exiting and saving");
	            	arrayListMethods.saveArrayFiles();
	            	customerQueue.saveQueueFiles();
	                exitProgram = true;
	                break;        
	            default:
	                System.out.println("Invalid Selection. Bypassed Input Validation. Exiting Program");
	                //System.exit(InputMismatchException);
	                break;
	        }
        } while (exitProgram == false);
        
        if (exitProgram == true) {
        	System.exit(0);
        }
        scr.close();
    }

    public static void printMenu(){
    	System.out.println("Lopez Urban Farm Catalog");
        System.out.println("\nMENU - Enter a number to proceed");
        System.out.println("\n1 - Search Crop Catalog");
        System.out.println("\n2 - Add new crop or to existing amount");
        System.out.println("\n3 - Remove from crop amount");
        System.out.println("\n4 - Edit crop name");
        System.out.println("\n5 - View current crop catalog");
        System.out.println("\n6 - Search customer logs");
        System.out.println("\n7 - Add new customer to logs");
        System.out.println("\n8 - Remove customer from logs");
        System.out.println("\n9 - Edit customer name or quantity");
        System.out.println("\n10 - View customer logs");
        System.out.println("\n11 - Add customer to customer queue");
        System.out.println("\n12 - Process next customer");
        System.out.println("\n13 - View customer queue");
        System.out.println("\n14 - Save files");
        System.out.println("\n15 - Exit Program");
        

    }
}
