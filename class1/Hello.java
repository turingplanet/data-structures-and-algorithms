package class1;

public class Hello {
    public static void main(String[] args) {
       System.out.println("Hello World"); 
       int array[] = {1, 3, 5, 7, 15, 99, 106, 234, 555, 6343, 9999};
       System.out.println(binarySearch(array, 7));
       System.out.println(search(array, 0, array.length, 7));
    }

    public static int binarySearch(int array[], int target) {
        int left = 0;
        int right = array.length - 1;
        while(left <= right) {  
            int mid = left + (right - left) / 2;
            if (array[mid] == target) { 
                return mid;
            } else if (target < array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int search(int nums[], int start, int end, int target) {
        if(end >= start) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                return search(nums, start, mid - 1, target);
            } 
            return search(nums, mid + 1, end, target);
        }
        return -1;
    }
}