package com.cdac.ads.avltree;

import com.cdac.ads.avlnode.AVLNode;

public interface AVLTreeINTF<T> {
	
	//adds a node in the avl tree.
	public AVLNode<T> addInTree(AVLNode<T> root, int keyHT);
	
	//removes a node from the avl tree.
	public AVLNode<T> removeFromTree(int keyHT);
	
	//checks if a key exists or not.
	public boolean searchKey(int keyHT);
}
