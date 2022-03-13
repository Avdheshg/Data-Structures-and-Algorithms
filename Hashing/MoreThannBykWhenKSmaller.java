import java.util.*;

public class MoreThannBykWhenKSmaller {

	public static void main(String[] args) {
		
	}

	public static void MoreThanNByk(int arr[], int k) {

		HashSet<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else if (map.size() < (k-1)) {
				map.put(arr[i], 1);
			} else {
				decreaseMap(map);
			}
		}

		for (Map.Entry<Integer, Integer> ele: map.entrySet()) {
			int count = findCount(arr, ele.getKey());

			if (count > (len/k)) {
				System.out.println(ele.getKey());
			}
		}
	}

	public static void decreaseMap(HashMap<Integer, Integer> map) {
		for (Map.Entry<Integer, Integer> ele: map.entrySet()) {
			map.put(ele, map.get(ele) -1);

			if (map.get(ele) == 0) {
				map.remove(ele);
			}
		}
	}

	public static int findCount(int arr[], int ele) {
		int count = 0;
		for (int x: arr) {
			if (x == ele) {
				count++;
			}
		}

		return count;
	}
}