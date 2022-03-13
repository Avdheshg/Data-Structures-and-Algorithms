import java.util.*;

public class RepeatingElement {

	public static void main(String[] args) {
		
		int arr[] = new int[]{1, 2, 3, 0, 3, 4, 5};

		// System.out.println("Repeated element " + sorting(arr));
		// System.out.println("Repeated element " + naive(arr));
		System.out.println("Repeated element " + withPhotos(arr));


	}

	

	public static int withPhotos(int arr[]) {

		boolean hasPhoto[] = new boolean[arr.length];

		for (int i = 0; i < arr.length; i++) {

			if (hasPhoto[arr[i]]) {

				return arr[i];
			}

			hasPhoto[arr[i]] = true;
		}

		return -1;

	}

	public static int sorting(int arr[]) {

		Arrays.sort(arr);
		for (int i = 1; i < arr.length-2; i++) {

			if (arr[i] == arr[i+1]) {
				return arr[i];
			}
		}

		return -1;

	}

	public static int naive(int arr[]) {

		for (int i = 0; i < arr.length; i++) {

			for (int j = i+1; j < arr.length; j++) {

				if (arr[i] == arr[j]) {

					return arr[i];
				}
			}
		}

		return -1;
	}


}