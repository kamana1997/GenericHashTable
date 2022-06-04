package com.cdac.ads.avltree;

import com.cdac.ads.avlnode.AVLNode;

public class AVLTree implements AVLTreeINTF {

	public AVLNode node;
	
	public AVLTree(AVLNode node) {
		super();
		this.node = node;
	}

	@Override
	public AVLNode addInTree(AVLNode node, int keyHT) {
		if (node == null) {
			return (new AVLNode(keyHT));
		}

		if (keyHT < node.getKeyHT())
			node.setlChild(addInTree(node.getlChild(), keyHT));
		else if (keyHT > node.getKeyHT())
			node.setrChild(addInTree(node.getrChild(), keyHT));
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
	public AVLNode removeFromTree(int keyHT) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean searchKey(int keyHT) {
		// TODO Auto-generated method stub
		return false;
	}

	// method to get the height of the tree
	public int heightOfTree(AVLNode node) {
		if (node == null) {
			return 0;
		}
		return node.getHeight();
	}

	// method to get maximum of two integers
	public int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public AVLNode rightRotateTree(AVLNode gParent) {
		AVLNode parent = gParent.getlChild();
		AVLNode parentRChild = parent.getrChild();

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
	public AVLNode leftRotateTree(AVLNode gParent) {
		AVLNode parent = gParent.getrChild();
		AVLNode parentLChild = parent.getlChild();

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
	int getBalanceFactor(AVLNode node) {
		if (node == null)
			return 0;

		return heightOfTree(node.getlChild()) - heightOfTree(node.getrChild());
	}

	// TODO To be removed after AVL Testing
	public void preOrder(AVLNode node) {
		if (node != null) {
			System.out.print(node.getKeyHT() + " ");
			preOrder(node.getlChild());
			preOrder(node.getrChild());
		}
	}
}
