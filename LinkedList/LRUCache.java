import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.*; 

public class LRUCache {

	public static void main(String[] args) { 
		
		LRU cache = new LRU(2); 

		// it will store a key (1) with value 
		// 10 in the cache. 
		cache.put(1, 10); 

		// it will store a key (2) with value 20 in the cache. 
		cache.put(2, 20); 
		System.out.println("Value for the key: 1 is " + cache.get(1)); // returns 10 

		// removing key 2 and store a key (3) with value 30 in the cache. 
		cache.put(3, 30); 

		System.out.println("Value for the key: 2 is " + cache.get(2)); // returns -1 (not found) 

		// removing key 1 and store a key (4) with value 40 in the cache. 
		cache.put(4, 40); 
		System.out.println("Value for the key: 1 is " + cache.get(1)); // returns -1 (not found) 
		System.out.println("Value for the key: 3 is " + cache.get(3)); // returns 30 
		System.out.println("Value for the key: 4 is " + cache.get(4)); // return 40 
	}

}


class Node { 
	int key; 
	int value; 
	Node pre; 
	Node next; 

	public Node(int key, int value) 
	{ 
		this.key = key; 
		this.value = value; 
	} 
} 

class LRU { 

	/*
		Define a HM for accessing the node information fast
		define cap and count/size
		define head and tail

		Constructor
			define HM, cap, and count
			Def head and tail and connect them

		deleteNode()
			As V R having head and tail as extra pointers so, if V delete a node V need to escape it i.e connect the previous node of the current node to the next of current node

		addToHead()
			As head is an extra pointer(which will remain fixed), so V insert the new node after the head and connect it with the next node of the head and with the head 
			Then connect head and new node
		
		get(key) = V R accessing the node by using key( O(1) operation to find the node )
			get means: V R using this item => and after get() is finished it will become a most recently used item
			if key is present in HM
				 make it as latest node 
				 return it's val
			if not present, return -1

		put(int key, int val)
			if key is present in HM
				update it's data and mark it as latest node
			not present
				Define a new node
				put it to the map
				if map has capacity
					mark new node as latest node
				not have capacity
					remove the last node (from HM and LL)
					mark new node as latest node
	*/

	private HashMap<Integer, Node> map; 
	private int capacity, count; 
	private Node head, tail; 

	public LRU(int capacity) 
	{ 
		this.capacity = capacity; 
		map = new HashMap<>(); 
		count = 0; 
		
		// creating dummy nodes for head and tail 
		head = new Node(0, 0); 
		tail = new Node(0, 0);
		// connecting head and tail 
		head.next = tail; 
		tail.pre = head; 
		// head.pre = null; 
		// tail.next = null; 
	} 

	public void deleteNode(Node node) {
		node.pre.next = node.next; 
		node.next.pre = node.pre; 
	} 

	public void addToHead(Node node) {
		node.next = head.next; 
		node.next.pre = node; 
		// connecting head with the new node
		node.pre = head; 
		head.next = node; 
	} 
 
	public int get(int key) 
	{ 
		if (map.get(key) != null) { 
			Node node = map.get(key); 
			int result = node.value; 
			deleteNode(node); 
			addToHead(node); 
			System.out.println("Got the value : " + 
				result + " for the key: " + key); 
			return result; 
		} 
		System.out.println("Did not get any value" + 
							" for the key: " + key); 
		return -1; 
	} 

	public void put(int key, int value) 
	{ 
		System.out.println("Going to put the (key, "+ 
			"value) : (" + key + ", " + value + ")"); 
		if (map.get(key) != null) { 
			// if the node is present in map, then take it out from the map, update it's val with the new val and put it after head
			Node node = map.get(key); 
			node.value = value; 
			deleteNode(node); 
			addToHead(node); 
		} 
		else { 
			Node node = new Node(key, value); 
			map.put(key, node); 
			if (count < capacity) { 
				count++; 
				addToHead(node); 
			} 
			else { 
				// delete the last node and add new node after head
				map.remove(tail.pre.key); 
				deleteNode(tail.pre); 
				addToHead(node); 
			} 
		} 
	} 
} 
 
