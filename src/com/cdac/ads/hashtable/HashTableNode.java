package com.cdac.ads.hashtable;

import com.cdac.ads.avltree.AVLNode;

public class HashTableNode<T extends Object>{
	private Integer key;
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
	
	public HashTableNode(Integer key, T value) {
		super();
		this.key = key;
		this.value = value;
		this.next = null;
	}
}
