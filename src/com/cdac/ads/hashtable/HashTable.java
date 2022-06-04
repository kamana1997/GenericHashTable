package com.cdac.ads.hashtable;

import java.util.ArrayList;
import java.util.Objects;

import com.cdac.ads.avlnode.AVLNode;
import com.cdac.ads.avltree.AVLTree;

public class HashTable<T> {
	// bucketArray is used to store array of chains
	private ArrayList<HashTableNode<Integer, T>> bucketArray;

	// Current capacity of array list
	private int numBuckets;

	// Current size of array list
	private int size;

	public HashTable() {
		bucketArray = new ArrayList<>();
		numBuckets = 10;
		size = 0;

		// Creating empty buckets
		for (int i = 0; i < numBuckets; i++) {
			bucketArray.add(null);
		}
	}

	public int getSize() {
		return this.size;
	}

	private final int hashCode(Integer key) {
		return Objects.hashCode(key);
	}

	// This implements hash function to find index
	// for a key
	private int getBucketIndex(Integer key) {
		int hashCode = hashCode(key);
		int index = hashCode % numBuckets;
		// key.hashCode() could be negative.
		index = index < 0 ? index * -1 : index;
		return index;
	}

	public void add(Integer key, T value) {

		// Find head of chain for given key
		int bucketIndex = getBucketIndex(key);
		int hashCode = hashCode(key);

		if(bucketArray.get(bucketIndex) == null) {
			HashTableNode<Integer, T> newNode = new HashTableNode<Integer, T>(key, value, hashCode);
			bucketArray.set(bucketIndex, newNode);
			return;
		}
		
		AVLNode root = new AVLNode(bucketArray.get(bucketIndex).next.getKey());
		HashTableNode<Integer, T> newNode = new HashTableNode<Integer, T>(key, value, hashCode);
		
		AVLTree tree = new AVLTree(root);
		
		root = tree.addInTree(root, newNode.getKey());
		
		size++;

		/*
		 * // If load factor goes beyond threshold, then // double hash table size if
		 * ((1.0 * size) / numBuckets >= 0.7) { ArrayList<HashTableNode<Integer, T>>
		 * tempArray = bucketArray; bucketArray = new ArrayList<>(); numBuckets = 2 *
		 * numBuckets; size = 0; for (int i = 0; i < numBuckets; i++)
		 * bucketArray.add(null);
		 * 
		 * for (HashTableNode<Integer, T> headNode : tempArray) { preOrder(new
		 * AVLNode(headNode.getKey()),headNode.getValue()); } }
		 */
	}

	/*
	 * public void preOrder(AVLNode node, T value) { if (node != null) {
	 * add(node.getKeyHT(),value); preOrder(node.getlChild());
	 * preOrder(node.getrChild()); } }
	 */
}
