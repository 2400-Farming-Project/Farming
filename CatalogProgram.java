import java.util.InputMismatchException;
import java.util.Scanner;

//Runs ArrayList and Queue methods and takes user input
public class CatalogProgram {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

	//References to other methods
        ArrayListMethods arrayListMethods = new ArrayListMethods();
        CustomerQueue customerQueue = new CustomerQueue();
        	
        //boolean to exit program
	boolean exitProgram = false;
                
	//Prints menu
	printMenu();

	//Uploads previously saved txt files 
	customerQueue.uploadQueueFiles();
	arrayListMethods.uploadArrayFiles();
		
        int numChoice = 0;
        do {
		//initial input validation for menu
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

		//All menu cases on a switch, do while loop does not end until exit program is chosen
	        switch (numChoice) {
		    //Search option for crops		
	            case 1:
	                System.out.println("Enter a crop to search for: ");
	                String searchCrop = scr.next();
	                arrayListMethods.searchItem(searchCrop);
	                break;
		    //Add option for crops
	            case 2:
	                System.out.println("Enter crop to create a new item or to add to quantity");
	                String addCropName = scr.next();
	                System.out.println("Enter quantity to add of crop");
	                int addCropQuantity = arrayListMethods.inputValidationInt(scr);
					arrayListMethods.checkForResizeCrops();
	                arrayListMethods.addItem(addCropName, addCropQuantity);
	                break;
		    //Remove option for crops
	            case 3:
	                System.out.println("Enter a crop to remove from its quantity");
	                String removeCropName = scr.next();
	                System.out.println("Enter amount to remove");
	                int removeCropAmount = arrayListMethods.inputValidationInt(scr);
	                arrayListMethods.removeItem(removeCropName, removeCropAmount);
	                break;    
		    //Edit name option for crops
	            case 4:
	                System.out.println("Enter an item to change its name: ");    
	                String itemNameToChange = scr.next();
	                System.out.println("Enter a new name");
	                String newItemName = scr.next();
	                arrayListMethods.editItem(itemNameToChange, newItemName);
	                break;
		    //Show crop catalog option
	            case 5:
	                arrayListMethods.showCatalog();
	                break;
		    //Search option for customers
	            case 6:
	            	System.out.println("Enter a customer name to search");
	            	String customerName = scr.next();
	            	arrayListMethods.searchCustomer(customerName);
	                break;
		    //Add customer option
	            case 7:
	                System.out.println("Enter customer name to add their name to the log or to add to their quantity");
	                String addCustomerName = scr.next();
	                System.out.println("Enter amount of crops taken");
	                int addCropTaken = arrayListMethods.inputValidationInt(scr);
	                arrayListMethods.addCustomer(addCustomerName, addCropTaken);
	                break;
		    //Remove customer option
	            case 8:
	                System.out.println("Enter a name to completely remove a customer from log");
	                String removeCustomerName = scr.next();
	                arrayListMethods.removeCustomer(removeCustomerName);
	                break;
		    //Edit customer information option, name or quantity
	            case 9:
	                System.out.println("Enter a customer name to edit their information");
	                String nameToChange = scr.next();
	                String newNameCustomer;
	                int quantityNew;
	                boolean inputValid = false;
			//Input validation for customer option choice
	                do {
	                	System.out.println("Do you want to edit their name or quantity?");
		                String decision = scr.next();
				//Switch cases for different spellings
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
		    //Show customer log option
	            case 10:	
	                arrayListMethods.showCustomerLog();
	                break;
		    //Add customer to waiting queue option
	            case 11:
	                System.out.println("Enter a customer name to add to queue");
	                String queueName = scr.next();
	                customerQueue.addCustomer(queueName);
	                break;
		    //Check in a customer from queue option
	            case 12:
	                System.out.println("Checking in next customer: " + customerQueue.getNextCustomer());
	                break;
		    //Show queue option
	            case 13:
	            	customerQueue.showQueue();
	                break;
		    //Manual Save option
	            case 14:
	            	System.out.println("Save files");
	            	arrayListMethods.saveArrayFiles();
	            	customerQueue.saveQueueFiles();
	            	break;
		    //Exit program option
	            case 15:
	                System.out.println("Exiting and saving");
	            	arrayListMethods.saveArrayFiles();
	            	customerQueue.saveQueueFiles();
	                exitProgram = true;
	                break;  
		    //Default case, invalid input 
	            default:
	                System.out.println("Invalid Selection. Bypassed Input Validation.");
	                break;
	        }
        } while (exitProgram == false); //loop for program

	//exits program if true
        if (exitProgram == true) {
        	System.exit(0);
        }
        scr.close();
    }

    //print menu method
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
