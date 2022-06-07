package com.cdac.ads.avltree;

public class AVLNode<T extends Object> {
	int keyHT;
	int height;
	AVLNode<T> lChild;
	AVLNode<T> rChild;
	T value;

	public AVLNode(int keyHT, T value) {
		this.keyHT = keyHT;
		this.height = 1;
		this.lChild = null;
		this.rChild = null;
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public int getKeyHT() {
		return keyHT;
	}

	public void setKeyHT(int keyHT) {
		this.keyHT = keyHT;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public AVLNode<T> getlChild() {
		return lChild;
	}

	public void setlChild(AVLNode<T> lChild) {
		this.lChild = lChild;
	}

	public AVLNode<T> getrChild() {
		return rChild;
	}

	public void setrChild(AVLNode<T> rChild) {
		this.rChild = rChild;
	}

}