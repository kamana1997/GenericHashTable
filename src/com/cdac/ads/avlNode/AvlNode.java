package com.cdac.ads.avlNode;

public class AvlNode {
	int data;
	AvlNode lChild;
	AvlNode rChild;

	public AvlNode(int data) {
		this.data = data;
		this.lChild = null;
		this.rChild = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public AvlNode getlChild() {
		return lChild;
	}

	public void setlChild(AvlNode lChild) {
		this.lChild = lChild;
	}

	public AvlNode getrChild() {
		return rChild;
	}

	public void setrChild(AvlNode rChild) {
		this.rChild = rChild;
	}

}
