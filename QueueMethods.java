import java.util.Queue;
import java.util.LinkedList;


public class QueueMethods implements QueueInterface<T> {
private static Queue<T> customerQueue = new LinkedList<>();

    @Override
    public void enqueue(T customer) {
        customerQueue.add(customer);
        System.out.println(customerQueue);
    }

    @Override
    public T dequeue() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dequeue'");
    }

    @Override
    public T peek() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'peek'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }




}
