package com.cdac.ads.hashtable;

import java.util.ArrayList;
import java.util.Objects;

import com.cdac.ads.avltree.AVLNode;
import com.cdac.ads.avltree.AVLTree;

public class HashTable<T extends Object> implements HashTableINTF<T> {
	// bucketArray is used to store array of chains
	private ArrayList<HashTableNode<T>> bucketArray;

	private AVLTree<T> tree;

	// Current capacity of array list
	private int numBuckets;

	// Current size of array list
	private int size;
	private int numDeleted;

	public HashTable() {
		bucketArray = new ArrayList<>();
		tree = new AVLTree<T>();
		numBuckets = 10;
		size = 0;
		numDeleted = 0;

		// Creating empty buckets
		for (int i = 0; i < numBuckets; i++) {
			bucketArray.add(null);
		}
	}

	@Override
	public void add(Integer key, T value) {

		// Find head of chain for given key
		int bucketIndex = getBucketIndex(key);

		if (bucketArray.get(bucketIndex) == null) {
			HashTableNode<T> newNode = new HashTableNode<T>(key, value);
			bucketArray.set(bucketIndex, newNode);
			// size++;
			// return;
		} else {
			AVLNode<T> root = null;
			if (bucketArray.get(bucketIndex).next == null) {
				root = new AVLNode<T>(key, value);
				bucketArray.get(bucketIndex).next = root;
			} else {
				root = bucketArray.get(bucketIndex).next;
			}
			root = tree.addInTree(root, key, value);
			bucketArray.get(bucketIndex).next = root;
		}

		size += 1;
		// If load factor goes beyond threshold, then
		// double hash table size
		if ((1.0 * (size + numDeleted)) / numBuckets >= 0.7) {
			ArrayList<HashTableNode<T>> oldBucketArray = bucketArray;
			bucketArray = new ArrayList<>();
			numBuckets = 2 * numBuckets;
			size = 0;
			for (int i = 0; i < numBuckets; i++) {
				bucketArray.add(null);
			}
			for (HashTableNode<T> hashNode : oldBucketArray) {
				if (hashNode != null) {
					if (hashNode.next != null) {
						AVLNode<T> travNode = hashNode.next;
						preOrderAdd(travNode);
					}
					add(hashNode.getKey(), hashNode.getValue());
				}
			}
		}
	}

	// called by operations class to display elements of HashTable
	@Override
	public void display() {
		AVLTree<T> avlTree = new AVLTree<>();
		for (HashTableNode<T> h : this.bucketArray) {
			if (h != null) {
				System.out.println(h.getKey() + " -> " + h.getValue());
				if (h.next != null) {
					avlTree.preOrder(h.next);
				}
			}
		}
	}

	@Override
	public void removeNodeFromTable(Integer key) {

		AVLTree<T> avlTree = new AVLTree<>();

		// Traversing in map to find location of said node
		for (int i = 0; i < bucketArray.size(); i++) {
			HashTableNode<T> temp = bucketArray.get(i);
			if (temp != null) {
				if (temp.getKey() != key) {
					if (temp.next != null) {
						AVLNode<T> root = temp.next;
						root = avlTree.deleteNode(root, key);

						// means root was the only tree node which got deleted
						temp.next = root;
						break;
					}
				} else {
					// if node has no tree
					if (temp.next == null) {
						bucketArray.set(i, null);
						break;
					}
					
					HashTableNode<T> tempNode = new HashTableNode<>(temp.next.getKeyHT(), temp.next.getValue());
					AVLNode<T> root = temp.next;
					
					//we have to deliberately remove root as in to produce shifting effect of nodes.
					root = avlTree.deleteNode(root, root.getKeyHT());
					tempNode.next = root;
					bucketArray.set(i, tempNode);
					break;

				}
			}
		}
		this.size -= 1;
		this.numDeleted += 1;
	}

	@Override
	public boolean checkDuplicateKeyUpdateValue(Integer key, T value) {
		AVLTree<T> avlTree = new AVLTree<>();
		for (HashTableNode<T> h : this.bucketArray) {
			if (h != null) {
				if (h.getKey() != key) {
					if (h.next != null) {
						if (avlTree.searchKeyInTree(h.next, key, value) == value) {
							return true;
						}
					}
				} else {
					h.setValue(value);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public T searchKeyValue(Integer key, T value) {
		AVLTree<T> avlTree = new AVLTree<>();
		for (HashTableNode<T> h : this.bucketArray) {
			if (h != null) {
				if (h.getKey() != key) {
					if (h.next != null) {
						T valueReturned = avlTree.searchKeyInTree(h.next, key, value);
						if (valueReturned != null) {
							return valueReturned;
						}
					}
				} else {
					return h.getValue();
				}
			}
		}
		return null;
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
		index = index < 0 ? index * -1 : index;
		return index;
	}

	// called when traversing in the tree while rehashing
	public void preOrderAdd(AVLNode<T> node) {
		if (node != null) {
			add(node.getKeyHT(), node.getValue());
			preOrderAdd(node.getlChild());
			preOrderAdd(node.getrChild());
		}
	}
}