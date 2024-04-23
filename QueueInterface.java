public interface QueueInterface<T> {
    //Adds customers to the end of queue
    void enqueue(T customer);
    
    //Removes customers from front of queue
    T dequeue();


    //Returns the customer in front of the line
    T peek();


    //Checks if queue is empty
    boolean isEmpty();


    //Returns the number of customers in queue
    int size();
} 