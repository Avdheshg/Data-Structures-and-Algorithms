class InOrder {

	public void inorderTraversal(Node root) {

		if (root == null) return;

		inorderTraversal(root.left);
		System.out.print(root.key + " ");
		inorderTraversal(root.right);

	}

}

class BinaryTree {

	public static void main(String[] args) {
		
		Node root = new Node(10);

		// left subtree
		root.left = new Node(20);

		root.left.left = new Node(40);
		root.left.right = new Node(50);

		root.left.right.left = new Node(70);
		root.left.right.right = new Node(80);

		// right subtree
		root.right.left = new Node(30);

		root.right.right = new Node(60);

		InOrder inorder = new InOrder();
		inorder.inorderTraversal(root);
	}

}


class Node {

	int key;
	Node left;
	Node right;

	public Node(int key) {

		this.key = key;
	}
}