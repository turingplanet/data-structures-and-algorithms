public class List {

    ListNode head;
    ListNode tail;
    int size;

    public static void main(String[] args) {
        List newList = new List();
        newList.insert(0, 0);
        newList.append(1);
        newList.insert(2, 2);
        newList.insert(5, 5);
        newList.append(3);
        newList.display();
    }

    public List() {
        head = null;
        tail = null;
        size = 0;
    }

    // append the new element to the end of the list
    public void append(int number) {
        ListNode newNode = new ListNode(number);
        if(tail == null) {
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void insert(int position, int number) {
        ListNode newNode = new ListNode(number);
        if (position > size) {
            System.out.println("Position invalid");
            return;
        } else if (position == 0) {
            newNode.next = head;
            head = newNode;
            if(tail == null) {
                tail = newNode;
            }
            size++;
        } else if (position == size) {
            this.append(number);
        } else {
            ListNode prev = head;
            for (int i = 0; i < position - 1; i++) {
                prev = prev.next;
            }
            ListNode next = prev.next;
            newNode.next = next;
            prev.next = newNode;
            size++;
        }
    }

    public void display() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + ", ");
            cur = cur.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
}
