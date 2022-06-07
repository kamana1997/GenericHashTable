package com.cdac.ads.hashtable;

public interface HashTableINTF<T extends Object> {
	
	public void add(Integer key, T value);
	
	public void display();

	public boolean checkDuplicateKeyUpdateValue(Integer key, T value);

	public T searchKeyValue(Integer key, T value);
	
	//TODO
	//public T removedNodeValue(Integer key);
}
