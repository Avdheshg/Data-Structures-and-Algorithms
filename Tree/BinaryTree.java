/*
	Node root = new Node(10);

	// left subtree
	root.left = new Node(20);

	root.left.left = new Node(40);
	root.left.right = new Node(50);

	// root.left.right.left = new Node(70);
	// root.left.right.right = new Node(80);

	// right subtree
	root.right = new Node(30);

	root.right.left = new Node(60);
	root.right.right = new Node(70);

	// ===================
	class Node {

		int key;
		Node left;
		Node right;

		public Node(int key) {

			this.key = key;
		}
	}


*/




import java.util.*;

class Node {

	int key;
	Node left;
	Node right;

	public Node(int key) {

		this.key = key;
	}
}

public class BinaryTree {

	public static void main(String[] args) {
		
		Node root = new Node(10);

		// left subtree
		root.left = new Node(20);

		root.left.left = new Node(40);
		root.left.right = new Node(50);

		// root.left.right.left = new Node(70);
		// root.left.right.right = new Node(80);

		// right subtree
		root.right = new Node(30);

		root.right.left = new Node(60);
		root.right.right = new Node(70);

		// System.out.println("Inorder traversal");
		// inorderTraversal(root);

		// System.out.println();

		// System.out.println("Preorder traversal");
		// preOrderTraversal(root);

		// System.out.println();

		System.out.println("Postorder traversal");
		postOrderTraversal(root);

		// System.out.println();

		// System.out.println("levelOrder traversal");
		// levelOrder(root);
	}

	public static void levelOrder(Node root) {

		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {

			Node temp = q.poll();
			System.out.print(temp.key + " ");

			if (temp.left != null) {
				q.add(temp.left);
			}

			if (temp.right != null) {
				q.add(temp.right);
			}
		}

	}

	public static void postOrderTraversal(Node root) {

		if (root == null) return;

		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.key + " ");

	}

	public static void preOrderTraversal(Node root) {

		if (root == null) return;

		System.out.print(root.key + " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);

	}

	public static void inorderTraversal(Node root) {

		if (root == null) return;

		inorderTraversal(root.left);
		System.out.print(root.key + " ");
		inorderTraversal(root.right);
		
	}

}





