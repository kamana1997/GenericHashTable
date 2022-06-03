package com.cdac.ads.avltree;

import com.cdac.ads.avlnode.AVLNode;

public interface AVLTreeINTF {
	
	//adds a node in the avl tree.
	public AVLNode addInTree(AVLNode root, int keyHT);
	
	//removes a node from the avl tree.
	public AVLNode removeFromTree(int keyHT);
	
	//checks if a key exists or not.
	public boolean searchKey(int keyHT);
}
