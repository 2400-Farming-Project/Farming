import java.util.LinkedList;
import java.util.Queue;

public class CustomerQueue {
    private Queue<String> customerQueue;

    public CustomerQueue() {
        customerQueue = new LinkedList<>();
    }

    public void addCustomer(String customerName) {
        customerQueue.add(customerName);
    }

    public String getNextCustomer() {
        return customerQueue.poll();
    }

    public void showQueue() {
        if (customerQueue.isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            System.out.println("Customer queue:");
            for (String customer : customerQueue) {
                System.out.println(customer);
            }
        }
    }

 public void saveQueueFiles() {
        try {
        if (customerQueueFile.createNewFile()) {
    //System.out.println("customerQueueFile created");
} else {
//System.out.println("File already exists");
}
} catch (IOException e) {
    System.out.println("An error occurred while creating the file.");
e.printStackTrace();
}
    
    try {
        PrintStream writer = new PrintStream(customerQueueFile);
    for (int index = 0; index < customerQueue.size(); index++) {
        if (((LinkedList<String>) customerQueue).get(index) != null) {
        writer.println(((LinkedList<String>) customerQueue).get(index));
    }
    }
    writer.close();
      } catch (FileNotFoundException e) {
          System.out.println("Customer Log names not saved, error has occurred");
      e.printStackTrace();
      }
    }

    public void uploadQueueFiles(){
        try {
            if (customerQueueFile.createNewFile()) {
              //System.out.println("customerQueueFile created");
            } else {
                //System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }

        Scanner fileReader;
        try {
            fileReader = new Scanner(customerQueueFile);
            while(fileReader.hasNext()){
                String currentName = fileReader.next();
                customerQueue.add(currentName);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File customerQueue not found");
            e.printStackTrace();
        }
        
    }
    
}
