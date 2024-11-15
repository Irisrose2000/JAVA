import java.util.Scanner;

class Queue {
    private int queueSize;
    private int[] queueArray;
    private int front; // Index of the front element
    private int rear;  // Index of the last element

    // Constructor to initialize the queue
    public Queue(int size) {
        this.queueSize = size;
        this.queueArray = new int[queueSize];
        this.front = -1;
        this.rear = -1;
    }

    // Method to enqueue an element to the queue
    public void enqueue(int value) {
        if (rear == queueSize - 1) {
            System.out.println("Queue is full. Cannot enqueue.");
        } else {
            if (front == -1) front = 0; // Set front to 0 if this is the first element
            queueArray[++rear] = value;
            System.out.println("Enqueued " + value + " to the queue.");
        }
    }

    // Method to dequeue an element from the queue
    public void dequeue() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty. Cannot dequeue.");
        } else {
            int value = queueArray[front++];
            System.out.println("Dequeued " + value + " from the queue.");
            if (front > rear) { // Reset front and rear if the queue becomes empty
                front = -1;
                rear = -1;
            }
        }
    }

    // Method to print the elements of the queue
    public void print() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue elements: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queueArray[i] + " ");
            }
            System.out.println();
        }
    }
}

public class QueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the queue: ");
        int size = scanner.nextInt();
        Queue queue = new Queue(size);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 -> ENQUEUE");
            System.out.println("2 -> DEQUEUE");
            System.out.println("3 -> PRINT");
            System.out.println("4 -> EXIT");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a number to enqueue: ");
                    int value = scanner.nextInt();
                    queue.enqueue(value);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.print();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
