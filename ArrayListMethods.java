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

  public void editItem(String itemName, String newItemName) {
    int index = itemNames.indexOf(itemName);
    if (index != -1) {
      itemNames.set(index, newItemName);
      System.out.println(itemName + " renamed to " + newItemName);
    } else {
      System.out.println("Item " + itemName + " not found in catalog.");
    }
  }

  public void showCatalog() {
    System.out.println("Contents of Catalog:");
    for (int i = 0; i < itemNames.size(); i++) {
      System.out.println(itemNames.get(i) + " stock: " + quantityOfItem.get(i));
    }
  }

  public void searchCustomer(String customerName) {
    int index = customerNames.indexOf(customerName);
      if (index != -1) {
        System.out.println(customerName + " stock: " + customerQuantity.get(index));
      }
      else {
        System.out.println(customerName + " not found in the customer logs.");
      }
  }

  public void addCustomer(String customerName, int quantity){
    int index = customerNames.indexOf(customerName);
      if (index != -1) {
        customerQuantity.set(index, customerQuantity.get(index) + quantity);
        System.out.println(customerName + " quantity updated: " + customerQuantity.get(index));
      }
      else {
        customerNames.add(customerName);
        customerQuantity.add(quantity);
        System.out.println(customerName + " added to the customer log with quantity: " + quantity);
      }
  }

  public void removeCustomer(String customerName) {
    int index = customerNames.indexOf(customerName);
      if (index != -1) {
        customerNames.remove(index);
        customerQuantity.remove(index);
        System.out.println(customerName + " removed from the catalog.");
      }
      else {
        System.out.println(customerName + " not found in the catalog.");
      }
  }

  public void editCustomerName(String customerName, String newCustomerName) {
    int index = customerNames.indexOf(customerName);
      if (index != -1) {
        customerNames.set(index, newCustomerNames);
        System.out.println(customerName + " renamed to " + newCustomerName);
      }
      else {
        System.out.println("Item " + customerName + " not found in catalog.");
      }
  }

  public void editCustomerQuantity(int customerAmount, int newCustomerAmount) {
    int index = customerNames.indexOf(customerName);
    int customerAmount = 0;

      if (index != -1) {
        customerAmount = customerQuantity.get(index);
        customerQuantity.set(index, newCustomerAmount);
        System.out.println(customerAmount + " renamed to " + newCustomerAmount);
      }
      else {
        System.out.println(customerName + " was not found in customer logs, no existing quantity to change");
      }
  }

  public void showCustomerLog() {
    System.out.println("Contents of Customer Log:");
    for (int i = 0; i < customerNames.size(); i++) {
      System.out.println(customerNames.get(i) + " has taken " + customerQuantity.get(i) + " crops");
    }
    if (customerNames.isEmpty()) {
      System.out.println("  Empty");
    }
  }

  
}
