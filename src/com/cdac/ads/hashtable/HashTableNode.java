package com.cdac.ads.hashtable;

import com.cdac.ads.avlnode.AVLNode;

public class HashTableNode<Integer, T extends Object>{
	private Integer key;
	private T value;
	final int hashCode;
	
	AVLNode<T> next;
	
	public int getHashCode() {
		return hashCode;
	}
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
	
	public HashTableNode(Integer key, T value, int hashCode) {
		super();
		this.key = key;
		this.value = value;
		this.hashCode = hashCode;
		this.next = null;
	}
}
