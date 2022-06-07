package com.cdac.ads.avltree;

public class AVLTree<T extends Object> implements AVLTreeINTF<T> {

	public AVLNode<T> node;

	@Override
	public AVLNode<T> addInTree(AVLNode<T> node, int keyHT, T value) {
		if (node == null) {
			AVLNode<T> root = new AVLNode<T>(keyHT, value);
			return root;
		}

		if (keyHT < node.getKeyHT())
			node.setlChild(addInTree(node.getlChild(), keyHT, value));
		else if (keyHT > node.getKeyHT())
			node.setrChild(addInTree(node.getrChild(), keyHT, value));
		else
			return node;

		node.setHeight(1 + max(heightOfTree(node.getlChild()), heightOfTree(node.getrChild())));

		int balance = getBalanceFactor(node);

		// If this node becomes unbalanced, then there
		// are 4 cases Left Left Case
		if (balance > 1 && keyHT < node.getlChild().getKeyHT())
			return rightRotateTree(node);

		// Right Right Case
		if (balance < -1 && keyHT > node.getrChild().getKeyHT())
			return leftRotateTree(node);

		// Left Right Case
		if (balance > 1 && keyHT > node.getlChild().getKeyHT()) {
			node.setlChild(leftRotateTree(node.getlChild()));
			return rightRotateTree(node);
		}

		// Right Left Case
		if (balance < -1 && keyHT < node.getrChild().getKeyHT()) {
			node.setrChild(rightRotateTree(node.getrChild()));
			return leftRotateTree(node);
		}

		return node;
	}

	@Override
	public T searchKeyInTree(AVLNode<T> node, Integer key, T value) {
		if (node == null) {
			return null;
		}
		if (node.getKeyHT() == key) {
			if (value != null) {
				node.setValue(value);
				return value;
			}
			return node.getValue();
		}
		if (node.getKeyHT() < key) {
			return searchKeyInTree(node.getlChild(), key, value);
		} else {
			return searchKeyInTree(node.getrChild(), key, value);
		}

	}

	@Override
	public AVLNode<T> deleteNode(AVLNode<T> root, int key) {

		// STEP 1: PERFORM STANDARD BST DELETE
		if (root == null) {
			return root;
		}

		// If the key to be deleted is smaller than
		// the root's key, then it lies in left subtree
		if (key < root.getKeyHT()) {
			root.setlChild(deleteNode(root.getlChild(), key));
		}

		// If the key to be deleted is greater than the
		// root's key, then it lies in right subtree
		else if (key > root.getKeyHT()) {
			root.setrChild(deleteNode(root.getrChild(), key));
		}

		// if key is same as root's key, then this is the node
		// to be deleted
		else {
			// node with only one child or no child
			if ((root.getlChild() == null) || (root.getrChild() == null)) {

				AVLNode<T> temp = null;

				if (temp == root.getlChild()) {
					temp = root.getrChild();
				} else {
					temp = root.getlChild();
				}

				// No child case
				if (temp == null) {
					temp = root;

					// here root(leaf) node can be deleted
					root = null;
				} else 
					// One child case
					// Copy the contents of the non-empty child
					root = temp;
			} else {
				// node with two children: Get the inorder

				// successor (smallest in the right subtree)
				AVLNode<T> temp = minValueNode(root.getrChild());

				// Copy the in-order successor's data to this node
				root.setKeyHT(temp.getKeyHT());
				root.setValue(temp.getValue());

				// Delete the in-order successor
				root.setrChild(deleteNode(root.getrChild(), temp.getKeyHT()));
			}
		}

		// If the tree had only one node then return null as the only node is deleted.
		if (root == null) {
			return root;
		}
			

		// STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
		root.setHeight(max(heightOfTree(root.getlChild()), heightOfTree(root.getrChild())) + 1);

		// STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
		// this node became unbalanced)
		int balance = getBalanceFactor(root);

		// If this node becomes unbalanced, then there are 4 cases
		// Left Left Case
		if (balance > 1 && getBalanceFactor(root.getlChild()) >= 0)
			return rightRotateTree(root);

		// Left Right Case
		if (balance > 1 && getBalanceFactor(root.getlChild()) < 0) {
			root.setlChild(leftRotateTree(root.getlChild()));
			return rightRotateTree(root);
		}

		// Right Right Case
		if (balance < -1 && getBalanceFactor(root.getrChild()) <= 0)
			return leftRotateTree(root);

		// Right Left Case
		if (balance < -1 && getBalanceFactor(root.getrChild()) > 0) {
			root.setrChild(rightRotateTree(root.getrChild()));
			return leftRotateTree(root);
		}

		return root;
	}

	// method to get the height of the tree
	public int heightOfTree(AVLNode<T> node) {
		if (node == null) {
			return 0;
		}
		return node.getHeight();
	}

	// method to get maximum of two integers
	public int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public AVLNode<T> rightRotateTree(AVLNode<T> gParent) {
		AVLNode<T> parent = gParent.getlChild();
		AVLNode<T> parentRChild = parent.getrChild();

		// Perform rotation
		parent.setrChild(gParent);
		gParent.setlChild(parentRChild);

		// Update heights
		gParent.setHeight(max(heightOfTree(gParent.getlChild()), heightOfTree(gParent.getrChild())) + 1);
		parent.setHeight(max(heightOfTree(parent.getlChild()), heightOfTree(parent.getrChild())) + 1);

		// Return new root
		return parent;
	}

	// method to rotate right
	public AVLNode<T> leftRotateTree(AVLNode<T> gParent) {
		AVLNode<T> parent = gParent.getrChild();
		AVLNode<T> parentLChild = parent.getlChild();

		// Perform rotation
		parent.setlChild(gParent);
		gParent.setrChild(parentLChild);

		// Update heights
		gParent.setHeight(max(heightOfTree(gParent.getlChild()), heightOfTree(gParent.getrChild())) + 1);
		parent.setHeight(max(heightOfTree(parent.getlChild()), heightOfTree(parent.getrChild())) + 1);

		// Return new root
		return parent;
	}

	// Get Balance factor of node N
	int getBalanceFactor(AVLNode<T> node) {
		if (node == null)
			return 0;

		return heightOfTree(node.getlChild()) - heightOfTree(node.getrChild());
	}

	public AVLNode<T> minValueNode(AVLNode<T> node) {
		AVLNode<T> current = node;

		/* loop down to find the leftmost leaf */
		while (current.getlChild() != null)
			current = current.getlChild();

		return current;
	}

	// called by display function of HashTable
	public void preOrder(AVLNode<T> node) {
		if (node != null) {
			System.out.println(node.getKeyHT() + " -> " + node.getValue());
			preOrder(node.getlChild());
			preOrder(node.getrChild());
		}
	}

}
