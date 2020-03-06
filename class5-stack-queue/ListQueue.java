public class ListQueue {

    static class QueueNode {
        int value;
        QueueNode next;
        public QueueNode(int value) {
            this.value = value;
        }
    }

    QueueNode front;
    QueueNode rear;

    public static void main(String[] args) {
        ListQueue queue = new ListQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

    public void enqueue(int value) {
        QueueNode newNode = new QueueNode(value);
        if (this.rear == null) { // Queue is empty
            this.front = this.rear = newNode;
            return;
        }
        this.rear.next = newNode;
        this.rear = newNode;
    }

    public int dequeue() {
        if (this.front == null) {
            return Integer.MIN_VALUE;
        }
        QueueNode frontNode = this.front;
        this.front = this.front.next;
        if (this.front == null) {
            this.rear = null;
        }
        return frontNode.value;
    }
}
