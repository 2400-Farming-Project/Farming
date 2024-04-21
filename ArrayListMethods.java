import java.util.ArrayList;


public class ArrayListMethods {
private static final int MAX_ITEMS = 100;
  
private static String[] itemNames = new String[MAX_ITEMS];
private static int[] quantityOfItem = new int[MAX_ITEMS];
  
  
public static void addItem(String itemName, int quantity) {
  for (int i = 0; i < itemNames.length; i++) {
  if (itemNames[i] == null) {
  itemNames[i] = itemName;
    quantityOfItem[i] = quantity;
    System.out.println( itemName + "added to the catalog with quantity" + quantity + ".");
    return();
    }
  }
  System.out.println("Catalog is full");
}

public static void showCatalog() {
  System.out.println("Contents of Catalog");
   for(int i = 0; i < itemNames.length; i++) {
     if (itemNames[i] != null) {
       System.out.println(itemNames[i] + "stock: " + quantityOfItem[i]);
       }
     }
  }

}
