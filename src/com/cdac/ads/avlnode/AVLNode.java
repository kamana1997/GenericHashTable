package com.cdac.ads.avlnode;

public class AVLNode {
	int keyHT;
	int height;
	AVLNode lChild;
	AVLNode rChild;

	public AVLNode(int keyHT) {
		this.keyHT = keyHT;
		this.height = 1;
		this.lChild = null;
		this.rChild = null;
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