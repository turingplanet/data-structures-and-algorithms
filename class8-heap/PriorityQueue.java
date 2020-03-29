import java.io.PrintWriter;
import java.util.*;

public class PriorityQueue {

    static class Node {
        int value;
        int priority;
        Node next;

        public Node(int value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }

    Node head = null;

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.push(5, 5);
        priorityQueue.push(4, 4);
        priorityQueue.push(3, 3);
        priorityQueue.push(7, 7);
        priorityQueue.push(2, 2);
        System.out.println(priorityQueue.peek().value);
        print(priorityQueue.head);
    }

    public static void print(Node node) {
        Node cur = node;
        while(cur != null) {
            System.out.print(cur.value + ", ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void push(int value, int priority) {
        if (head == null) {
            head = new Node(value, priority);
            return;
        }
        Node cur = head;
        Node newNode = new Node(value, priority);
        if(head.priority < priority) {
            newNode.next = head;
            this.head = newNode;
        } else {
            while(cur.next != null && cur.next.priority > priority) {
                cur = cur.next;
            }
            newNode.next = cur.next;
            cur.next = newNode;
        }
    }

    public Node peek() {
        return head;
    }

    public Node pop() {
        if (head == null) {
            return null;
        }
        Node temp = head;
        head = head.next;
        return temp;
    }


    public boolean isEmpty() {
        return head == null;
    }

}
