/*
 * @Author				: Kamana Mathur [220340120097] & Udit Keskar [220340120100]
 * @ProjectTitle		: ADS-Mini Project 
 * @ProblemStatement	: Implement Generic HashTable that uses Chaining for Collision Handling
 * @Date				: 01-06-2022 -> 09-06-2022
 */

package com.cdac.ads.avltree;

public class AVLNode<T extends Object> {
	int keyHT;
	int height;
	AVLNode<T> lChild;
	AVLNode<T> rChild;
	T value;

	// Parameterized constructor
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