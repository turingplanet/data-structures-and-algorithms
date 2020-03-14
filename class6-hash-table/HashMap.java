import java.util.ArrayList;

public class HashMap {

    static class HashNode<String, Integer> {
        String key;
        Integer value;
        HashNode<String, Integer> next;
        public HashNode(String key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    private ArrayList<HashNode<String, Integer>> bucketArray;
    private int numBuckets;
    private int size;

    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.add("a", 1);
        map.add("b", 2);
        map.add("c", 3);
        System.out.println(map.get("a"));
        System.out.println(map.get("b"));
        System.out.println(map.get("c"));
    }

    public HashMap() {
        bucketArray = new ArrayList<>();
        numBuckets = 10;
        size = 0;
        for(int i = 0; i < numBuckets; i++) {
            bucketArray.add(null);
        }
    }

    private int getBucketIndex(String key) {
        int hashCode = key.hashCode();
        int index = hashCode % numBuckets;
        return index;
    }


    public void add(String key, Integer value) {
        int bucketIndex = getBucketIndex(key);
        HashNode<String, Integer> head = bucketArray.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = bucketArray.get(bucketIndex);
        HashNode<String, Integer> newNode = new HashNode<String, Integer>(key, value);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);
        if ((1.0 * size) / numBuckets >= 0.7) {
            ArrayList<HashNode<String, Integer>> temp = bucketArray;
            bucketArray = new ArrayList<>();
            numBuckets = 2 * numBuckets;
            size = 0;
            for (int i = 0; i < numBuckets; i++) {
                bucketArray.add(null);
            }
            for (HashNode<String, Integer> headNode : temp) {
                while(headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }

    public Integer get(String key) {
        int bucketIndex = getBucketIndex(key);
        HashNode<String, Integer> head = bucketArray.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public Integer remove(String key) {
        int bucketIndex = getBucketIndex(key);
        HashNode<String, Integer> head = bucketArray.get(bucketIndex);
        HashNode<String, Integer> prev = null;
        while (head != null) {
            if (head.key.equals(key))
                break;
            prev = head;
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        size--;
        if (prev != null) {
            prev.next = head.next;
        } else {
            bucketArray.set(bucketIndex, head.next);
        }
        return head.value;
    }


    public int size() {
                            return size;
                                        }

    public boolean isEmpty() {
                                   return size() == 0;
}
}
