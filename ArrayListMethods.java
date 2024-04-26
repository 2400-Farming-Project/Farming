import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class ArrayListMethods {
  private static List<String> itemNames;
  private static List<Integer> quantityOfItem;
  private static List<String> customerNames;
  private static List<Integer> customerQuantity;
  private final int MAX_CROPS = 100;
  private final int MAX_CUSTOMERS = 100;
  Scanner scr = new Scanner(System.in);

  public ArrayListMethods() {
    itemNames = new ArrayList<>(MAX_CROPS);
    quantityOfItem = new ArrayList<>(MAX_CROPS);
    customerNames = new ArrayList<>(MAX_CUSTOMERS);
    customerQuantity = new ArrayList<>(MAX_CUSTOMERS);
      
  }
      
  public void searchItem(String itemName) {
    int index = itemNames.indexOf(itemName);
    if (index != -1) {
      System.out.println(itemName + " stock: " + quantityOfItem.get(index));
    } else {
      System.out.println(itemName + " not found in the catalog.");
    }

  }
      
  public void addItem(String itemName, int quantity) {
    int index = itemNames.indexOf(itemName);
    if (index != -1) {
      quantityOfItem.set(index, quantityOfItem.get(index) + quantity);
      System.out.println(itemName + " quantity updated: " + quantityOfItem.get(index));
    } else {
      itemNames.add(itemName);
      quantityOfItem.add(quantity);
      System.out.println(itemName + " added to the catalog with quantity: " + quantity);
    }
  }


  public void removeItem(String itemName, int quantity) {
    int index = itemNames.indexOf(itemName);
    if (index != -1) {
      int currentQuantity = quantityOfItem.get(index);
      if (currentQuantity >= quantity) {
        quantityOfItem.set(index, currentQuantity - quantity);
        System.out.println(quantity + " " + itemName + " removed from the catalog. Quantity left: " + quantityOfItem.get(index));
        if (quantityOfItem.get(index) == 0) {
          System.out.println("Do you want to remove " + itemName + " from the Catalog (Yes or No)");
          String removeChoice = scr.next();
          if (removeChoice == "Yes" || removeChoice == "yes" || removeChoice == "y" || removeChoice == "Y") {
            itemNames.remove(index);
            quantityOfItem.remove(index);
            System.out.println(itemName + " removed from the catalog.");
              
          }
        } 
      } else {
          System.out.println("Not enough " + itemName + " in stock.");
      }
    } else {
        System.out.println(itemName + " not found in the catalog.");
    }
  }

  public static void editItem(String itemName, String newItemName) {
    for (int i = 0; i < itemNames.length; i++) {
      if (itemName.equals(itemNames[i])) {
        itemNames[i] = newItemName;
        System.out.println(itemName + " renamed to " + newItemName);
        return;
      }
    }
    System.out.println("Original item " + itemName + " not found in catalog.");
  }
    
  public static void addCustomer(String customerName){
    for (int i = 0; i < customerNames.length; i++) {
      if (customerName.equals(customerNames[i])) {
        System.out.println(customerName + " is already in the customer list.");
        return;
      }
    }
    for (int i=0; i < customerNames.length; i++) {
      if (customerNames[i] == null) {
        customerNames[i] = customerName;
        System.out.println(customerName + " added to the customer list.");
        return;
      }
    }
  }

  public static void removeCustomer(String customerName) {
    for (int i = 0; i < customerNames.length; i++) {
      if (customerName.equals(customerNames[i])) {
        customerNames[i] = null;
        System.out.println(customerName + " removed from the customer list.");
        return;
      }
    }
    System.out.println(customerName + " not found in the customer list.");
  }

  public static void showCustomerLog() {
    System.out.println("Customer Log:");
    for(int i = 0; i < customerNames.length; i++) {
      if (customerNames[i] != null) {
        System.out.println(customerNames[i] + "; Crops taken: " + customerQuantity[i]);
      }
    }
  }
    
  public static void showCatalog() {
    System.out.println("Contents of Catalog");
    for(int i = 0; i < itemNames.length; i++) {
      if (itemNames[i] != null) {
        System.out.println(itemNames[i] + "; Stock: " + quantityOfItem[i]);
        }
      }
    }

}