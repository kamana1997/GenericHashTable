/*
 * @Author				: Kamana Mathur [220340120097] & Udit Keskar [220340120100]
 * @ProjectTitle		: ADS-Mini Project 
 * @ProblemStatement	: Implement Generic HashTable that uses Chaining for Collision Handling
 * @Date				: 01-06-2022 -> 09-06-2022
 */

package com.cdac.ads.hashtable;

import com.cdac.ads.avltree.AVLNode;

public class HashTableNode<T extends Object> {
	// Key is always Integer
	private Integer key;
	// Value can be generic
	private T value;

	AVLNode<T> next;

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	// Parameterized constructor
	public HashTableNode(Integer key, T value) {
		super();
		this.key = key;
		this.value = value;
		this.next = null;
	}
}
