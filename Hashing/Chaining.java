import java.util.*;

public class Chaining {


	private int size;
	private ArrayList<LinkedList<Integer>> map;

	public Chaining(int size) {
		this.size = size;
		map = new ArrayList<>();

		for (int i = 0; i < size; i++) {
			map.add(new LinkedList<>());
		}
	}

	public void addElement(int key) {
		int idx = key % size;
		map.get(idx).add(key);
		System.out.println("Adding " + key + " at " + idx);
	}

	public void removeElement(int key) {
		int idx = key % size;
		map.get(idx).remove((Integer)key);
		System.out.println("Removed " + key + " from " + idx);

		System.out.println("Now map is ");
		printMap();
	}

	public boolean search(int key) {

		int idx = key % size;

		if (map.get(idx).contains(key)) {
			System.out.println(key + " found ");
			return true;
		}

		System.out.println(key + " not found ");
		return false;		
	}

	public void printMap() {

		for (int i = 0; i < map.size(); i++) {

			System.out.print(i + " -> ");
			for (int element : map.get(i)) {
				System.out.print(element + " ");
			}

			System.out.println();
		}
	}

	public static void main(String[] args) {

		Chaining chaining = new Chaining(7);

		chaining.addElement(70);
		chaining.addElement(71);
		chaining.addElement(9);
		chaining.addElement(56);
		chaining.addElement(32);

		chaining.printMap();

		// chaining.removeElement(70);
		// chaining.removeElement(71);
		// chaining.removeElement(9);
		// chaining.removeElement(56);
		// chaining.removeElement(32);

		chaining.search(71);
	}

}