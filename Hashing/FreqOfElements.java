import java.util.*;

public class FreqOfElements {
    
    // naive: O(n * (n+n))
    public static void naive(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            boolean isVis = false;

            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    isVis = true;
                    break;
                }
            }

            if (isVis) {
                continue;
            }

            int count = 1;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            System.out.println("For " + arr[i] + " freq : " + count);
        }
    }

    // Efficient: O(n+n) || O(N)
    public static void efficient(int arr[]) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> x: map.entrySet()) {
            System.out.println(x.getKey() + " " + x.getValue());
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{10,20,20,30,10,10,20,20,30,10}; 
        // naive(arr);   
        efficient(arr);   
    }

}
