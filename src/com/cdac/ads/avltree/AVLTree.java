package com.cdac.ads.avltree;

import com.cdac.ads.avlnode.AVLNode;

public class AVLTree<T extends Object> {//implements AVLTreeINTF {

	public AVLNode<T> node;

	//@Override
	public AVLNode<T> addInTree(AVLNode<T> node, int keyHT, T value) {
		if (node == null) {
			AVLNode<T> root = new AVLNode<T>(keyHT,value);
			return root;
		}

		if (keyHT < node.getKeyHT())
			node.setlChild(addInTree(node.getlChild(), keyHT,value));
		else if (keyHT > node.getKeyHT())
			node.setrChild(addInTree(node.getrChild(), keyHT,value));
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

	//@Override
	public AVLNode<T> removeFromTree(int keyHT) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public boolean searchKey(int keyHT) {
		// TODO Auto-generated method stub
		return false;
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

	// TODO To be removed after AVL Testing
	public void preOrder(AVLNode<T> node) {
		if (node != null) {
			System.out.println(node.getKeyHT() + " " + node.getValue());
			preOrder(node.getlChild());
			preOrder(node.getrChild());
		}
	}
	
	public boolean bsForDuplicateCheck(AVLNode<T> node,Integer key, T value) {

		if(node == null) {
			return false;
		}
		if(node.getKeyHT() == key) {
			node.setValue(value);
			return true;
		}
		if(node.getKeyHT()<key) {
			return bsForDuplicateCheck(node.getlChild(),key,value);
		}else {
			return bsForDuplicateCheck(node.getrChild(), key,value);
		}
		
	}

	public T searchKeyInTree(AVLNode<T> node, Integer key) {
		if (node == null) {
			return null;
		}
		if (node.getKeyHT() == key) {
			return node.getValue();
		}
		if(node.getKeyHT()<key) {
			return searchKeyInTree(node.getlChild(),key);
		}else {
			return searchKeyInTree(node.getrChild(), key);
		}
		
	}
}
