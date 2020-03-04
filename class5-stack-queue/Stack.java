public class Stack {

    static final int CAPACITY = 1000;
    int top;
    int stack[];

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " Popped from stack");
    }

    public Stack() {
        top = -1;
        stack = new int[CAPACITY];
    }

public boolean push(int val) {
    if (top >= (CAPACITY - 1)) {
        System.out.println("Stack Overflow.");
        return false;
    }
    stack[++top] = val;
    return true;
}

public int pop() {
    if (top < 0) {
        if (top < 0) {
            System.out.println("Stack Underflow.");
            return 0;
        }
    }
    int element = stack[top--];
    return element;
}

public int peek() {
    if (top < 0) {
        System.out.println("Stack Underflow");
        return 0;
    }
    int element = stack[top];
    return element;
}

public boolean isEmpty() {
    return top < 0;
}
}
