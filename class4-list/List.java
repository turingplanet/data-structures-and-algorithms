public class List {

    ListNode head;
    ListNode tail;
    int size;

    public static void main(String[] args) {
        List newList = new List();
        newList.insert(0, 0);
        newList.append(1);
        newList.insert(2, 2);
        newList.append(3);
        newList.display();
        // search
        System.out.println();
        System.out.println(newList.search(0));
        System.out.println(newList.search(3));
        System.out.println(newList.search(4));
        // update
        newList.update(2, 4);
        newList.update(0, -1);
        newList.update(3, 5);
        newList.display();
    }

    public List() {
        head = null;
        tail = null;
        size = 0;
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
    // append the new element to the end of the list
    public void append(int number) {
        if(size == 0) {
            ListNode newNode = new ListNode(number);
            head = newNode;
            tail = head;
            size++;
            return;
        }
        ListNode newNode = new ListNode(number);
        if(tail == null) {
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void delete(int number) {
        if(head != null && head.val == number) { // delete the head node
            head = head.next;
            size--;
            if(size == 0) { // corner case: no element is left
                tail = head;
            }
        } else {
            ListNode prev = head;
            ListNode cur = head;
            while (prev != null && cur != null) {
                if (cur.val == number) {
                    if(cur == tail) { // corner case: delete the last element
                        tail = prev;
                    }
                    prev.next = cur.next;
                    size--;
                    return;
                }
                prev = cur;
                cur = cur.next;
            }
        }
    }

    public int search(int number) {
        ListNode prev = head;
        ListNode cur = head;
        for(int index = 0; prev != null && cur != null; index++) {
            if(cur.val == number) {
                return index;
            }
            prev = cur;
            cur = cur.next;
        }
        return -1;
    }

    public int update(int oldValue, int newValue) {
        ListNode prev = head;
        ListNode cur = head;
        for(int index = 0; prev != null && cur != null; index++) {
            if(cur.val == oldValue) {
                cur.val = newValue;
                return index;
            }
            prev = cur;
            cur = cur.next;
        }
        return -1;
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
