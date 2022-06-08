/*
 * @Author				: Hardik Agarwal [220340120083] & Joy Pahari [220340120092]
 * @ProjectTitle		: ADS-Mini Project 
 * @ProblemStatement	: Implement Generic HashTable that uses Chaining for Collision Handling
 * @Date				: 01-06-2022 -> 09-06-2022
 */

package com.cdac.ads.avltree;

public interface AVLTreeINTF<T> {

	// Method to add a node in AVLTree.
	// Returns node.
	public AVLNode<T> addInTree(AVLNode<T> node, int keyHT, T value);

	// Method to search for an element present in AVLTree.
	// Returns value of the element.
	public T searchKeyInTree(AVLNode<T> node, Integer key, T value);

	// Method to delete a node from AVLTree.
	// Returns the deleted node.
	public AVLNode<T> deleteNode(AVLNode<T> root, int keyHT);
}
