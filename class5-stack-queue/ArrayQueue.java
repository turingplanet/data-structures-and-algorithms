public class ArrayQueue {

    int front, rear, size;
    int capacity;
    int array[];

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(4);
    }

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        front = rear = size = 0;
        array = new int[capacity];
    }

public void enqueue(int item) {
    if (isFull()) return;
    array[rear] = item;
    rear = (rear + 1) % capacity;
    size++;
    System.out.println(item + " is enqueued.");
}

public int dequeue() {
    if (isEmpty()) return Integer.MIN_VALUE;
    int item = array[front];
    front = (front + 1) % capacity;
    size --;
    return item;
}

public int peek() {
    if (isEmpty()) return Integer.MIN_VALUE;
    return array[front];
}

public boolean isFull() {
    return size == capacity;
}

public boolean isEmpty() {
    return size == 0;
}

}
