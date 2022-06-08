/*
 * @Author				: Hardik Agarwal [220340120083] & Joy Pahari [220340120092]
 * @ProjectTitle		: ADS-Mini Project 
 * @ProblemStatement	: Implement Generic HashTable that uses Chaining for Collision Handling
 * @Date				: 01-06-2022 -> 09-06-2022
 */

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

		// If this node becomes unbalanced, then there are 4 cases :
		// 01. Left Left Case
		if (balance > 1 && keyHT < node.getlChild().getKeyHT())
			return rightRotateTree(node);

		// 02. Right Right Case
		if (balance < -1 && keyHT > node.getrChild().getKeyHT())
			return leftRotateTree(node);

		// 03. Left Right Case
		if (balance > 1 && keyHT > node.getlChild().getKeyHT()) {
			node.setlChild(leftRotateTree(node.getlChild()));
			return rightRotateTree(node);
		}

		// 04. Right Left Case
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
		if (key < node.getKeyHT()) {
			return searchKeyInTree(node.getlChild(), key, value);
		} else {
			return searchKeyInTree(node.getrChild(), key, value);
		}

	}

	@Override
	public AVLNode<T> deleteNode(AVLNode<T> root, int key) {

		// BST delete
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
				// node with two children: Get the in-order

				// successor (smallest in the right subtree)
				AVLNode<T> temp = minValueNode(root.getrChild());

				// Copy the in-order successor's data to this node
				root.setKeyHT(temp.getKeyHT());
				root.setValue(temp.getValue());

				// Delete the in-order successor
				root.setrChild(deleteNode(root.getrChild(), temp.getKeyHT()));
			}
		}

		// If the tree has only one node then return null as the only node is deleted.
		if (root == null) {
			return root;
		}

		// Update height of the current node.
		root.setHeight(max(heightOfTree(root.getlChild()), heightOfTree(root.getrChild())) + 1);

		// Get the balance factor of this node.
		int balance = getBalanceFactor(root);

		// If this node becomes unbalanced, then there are 4 cases :
		// 01. Left Left Case
		if (balance > 1 && getBalanceFactor(root.getlChild()) >= 0)
			return rightRotateTree(root);

		// 02. Left Right Case
		if (balance > 1 && getBalanceFactor(root.getlChild()) < 0) {
			root.setlChild(leftRotateTree(root.getlChild()));
			return rightRotateTree(root);
		}

		// 03. Right Right Case
		if (balance < -1 && getBalanceFactor(root.getrChild()) <= 0)
			return leftRotateTree(root);

		// 04. Right Left Case
		if (balance < -1 && getBalanceFactor(root.getrChild()) > 0) {
			root.setrChild(rightRotateTree(root.getrChild()));
			return leftRotateTree(root);
		}

		return root;
	}

	// Method to get the height of the tree.
	public int heightOfTree(AVLNode<T> node) {
		if (node == null) {
			return 0;
		}
		return node.getHeight();
	}

	// Method to get maximum of two integers.
	public int max(int a, int b) {
		return (a > b) ? a : b;
	}

	// Method to rotate left.
	public AVLNode<T> rightRotateTree(AVLNode<T> gParent) {
		AVLNode<T> parent = gParent.getlChild();
		AVLNode<T> parentRChild = parent.getrChild();

		// Perform rotation.
		parent.setrChild(gParent);
		gParent.setlChild(parentRChild);

		// Updates height.
		gParent.setHeight(max(heightOfTree(gParent.getlChild()), heightOfTree(gParent.getrChild())) + 1);
		parent.setHeight(max(heightOfTree(parent.getlChild()), heightOfTree(parent.getrChild())) + 1);

		// Return new root.
		return parent;
	}

	// Method to rotate right.
	public AVLNode<T> leftRotateTree(AVLNode<T> gParent) {
		AVLNode<T> parent = gParent.getrChild();
		AVLNode<T> parentLChild = parent.getlChild();

		// Perform rotation.
		parent.setlChild(gParent);
		gParent.setrChild(parentLChild);

		// Updates height.
		gParent.setHeight(max(heightOfTree(gParent.getlChild()), heightOfTree(gParent.getrChild())) + 1);
		parent.setHeight(max(heightOfTree(parent.getlChild()), heightOfTree(parent.getrChild())) + 1);

		// Return new root.
		return parent;
	}

	// Get Balance factor of node N.
	int getBalanceFactor(AVLNode<T> node) {
		if (node == null)
			return 0;

		return heightOfTree(node.getlChild()) - heightOfTree(node.getrChild());
	}

	public AVLNode<T> minValueNode(AVLNode<T> node) {
		AVLNode<T> current = node;

		// Loop down to find the leftmost leaf.
		while (current.getlChild() != null)
			current = current.getlChild();

		return current;
	}

	// This method is called by display function of HashTable.
	public void preOrder(AVLNode<T> node) {
		if (node != null) {
			System.out.print(" --> (" + node.getKeyHT() + " , " + node.getValue() + ")");
			preOrder(node.getlChild());
			preOrder(node.getrChild());
		}
	}

}
