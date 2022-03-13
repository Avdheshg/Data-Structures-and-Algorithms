
import java.util.*;

public class MeetingTheMaxGuest {

	public static void main(String[] args) {

		// int arr[] = { 900, 600, 700};
        // int dep[] = { 1000, 800, 730};

		// int arr[] = { 800, 700, 600, 500};
  //       int dep[] = { 840, 820, 830, 530};

		int arr[] = {1, 2, 9, 5, 5};
        int dep[] = {4, 5, 12, 9, 12};

        // int arr[] = { 900,940,950,1100,1500,1800};
        // int dep[] = {910,1200,1120,1130,1900,2000};
        int len = arr.length;
		
		maxGuest(arr, dep, len);

	}


	public static void maxGuest(int arr[], int dep[], int len) {

		// int i = 1, curr = 1, res = 1;
		int i = 0, curr = 0, res = 0;
		int j = 0;


		Arrays.sort(arr);
		Arrays.sort(dep);
		
		System.out.println("After sorting : ");
		System.out.println("arr[] : " + Arrays.toString(arr));
		System.out.println("dep[] : " + Arrays.toString(dep));

		while (i < arr.length && j < dep.length) {
			if (arr[i] <= dep[j]) {			// this means that the guests are coming
				// System.out.println("");
				curr++;
				i++;
				res = Math.max(res, curr);
			} else {						// this means that the guests are leaving
				curr--;
				j++;
			}
					// this will record the max number of guests present in the party at particular time
		}
		System.out.println("Max guests : " + res);

	}

	// public static void maxGuest(int arr[], int dep[], int len) {

	// 	int count = 0;

	// 	Interval interval = new Interval(arr[0], dep[0]);

	// 	int i = 0;
	// 	while (i < len) {
	// 		System.out.println("in while : " );
	// 		if (interval.startTime < arr[i]) {
	// 			i++;
	// 			continue;
	// 		} else if (interval.endTime > dep[i]) {

	// 		} else {
	// 			interval.startTime = Math.min(arr[i], interval.startTime);
	// 			interval.endTime = Math.max(dep[i], interval.endTime);
	// 			count++;
	// 		}
	// 	}

	// 	System.out.println("Count : " + count);
	// }
}

// class Interval {
// 	int startTime;
// 	int endTime;

// 	public Interval(int startTime, int endTime) {
// 		this.startTime = startTime;
// 		this.endTime = endTime;
// 	}
// }