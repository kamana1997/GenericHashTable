package com.cdac.ads.avlnode;

public class AVLNode {
	int key;
	int height;
	AVLNode lChild;
	AVLNode rChild;

	public AVLNode(int key) {
		this.key = key;
		this.lChild = null;
		this.rChild = null;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public AVLNode getlChild() {
		return lChild;
	}

	public void setlChild(AVLNode lChild) {
		this.lChild = lChild;
	}

	public AVLNode getrChild() {
		return rChild;
	}

	public void setrChild(AVLNode rChild) {
		this.rChild = rChild;
	}

}