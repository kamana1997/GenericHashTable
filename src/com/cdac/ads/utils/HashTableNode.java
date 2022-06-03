package com.cdac.ads.utils;

public class HashTableNode<T extends Object>{
	private int key;
	private T data;

	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public HashTableNode(int key, T data) {
		super();
		this.key = key;
		this.data = data;
	}
}
