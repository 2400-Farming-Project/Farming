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
}