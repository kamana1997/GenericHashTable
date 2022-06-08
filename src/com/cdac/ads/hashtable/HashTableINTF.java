/*
 * @Author				: Hardik Agarwal [220340120083] & Joy Pahari [220340120092]
 * @ProjectTitle		: ADS-Mini Project 
 * @ProblemStatement	: Implement Generic HashTable that uses Chaining for Collision Handling
 * @Date				: 01-06-2022 -> 09-06-2022
 */

package com.cdac.ads.hashtable;

public interface HashTableINTF<T extends Object> {

	// Method to add node to hashTable.
	public void add(Integer key, T value);

	// Method to display elements present in hashTable.
	public void display();

	// Method to check for duplicate key (while adding node).
	// Returns true or false.
	public boolean checkDuplicateKeyUpdateValue(Integer key, T value);

	// Method to search for key.
	// Returns value present at key.
	public T searchKeyValue(Integer key, T value);

	// Method to delete element from hashTable.
	public void removeNodeFromTable(Integer key);
}
