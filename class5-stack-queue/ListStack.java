public class ListStack {

    static class StackNode {
        int val;
        StackNode next;
        StackNode(int val) {
            this.val = val;
        }
    }

    StackNode top;

    public static void main(String[] args) {
        ListStack listStack = new ListStack();
        listStack.push(1);
        listStack.push(2);
        listStack.push(3);
        System.out.println(listStack.pop() );
        System.out.println(listStack.pop() );
    }

    public ListStack() {
        top = null;
    }

public void push(int val) {
    StackNode newNode = new StackNode(val);
    if (top == null) {
        top = newNode;
    } else {
        StackNode temp = top;
        top = newNode;
        newNode.next = temp;
    }
    System.out.println(val + " is pushed to stack.");
}

public int pop() {
    if (top == null) {
        System.out.println("Stack is Empty.");
        return Integer.MIN_VALUE;
    }
    int popped = top.val;
    top = top.next;
    return popped;
}

public int peek() {
    if (top == null) {
        System.out.println("Stack is empty.");
        return Integer.MIN_VALUE;
    }
    return top.val;
}

public boolean isEmpty() {
    return top == null;
}
}
