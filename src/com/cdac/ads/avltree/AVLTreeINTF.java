package com.cdac.ads.avltree;

public interface AVLTreeINTF<T> {
	
	//adds a node in the AVL tree.
	public AVLNode<T> addInTree(AVLNode<T> node, int keyHT, T value);
	
	//removes a node from the AVL tree.
	public T searchKeyInTree(AVLNode<T> node, Integer key, T value);
	
	//checks if a key exists or not.
	public AVLNode<T> deleteNode(AVLNode<T> root, int keyHT);
}
