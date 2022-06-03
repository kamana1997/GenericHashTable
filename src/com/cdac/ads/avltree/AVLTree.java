package com.cdac.ads.avltree;

import com.cdac.ads.avlnode.AVLNode;

public class AVLTree implements AVLTreeINTF {

	private AVLNode root;

	@Override
	public AVLNode addInTree(AVLNode root, int keyHT) {
		// TODO Auto-generated method stub
		return null;
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
 
        //  Update heights
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
}
