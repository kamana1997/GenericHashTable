package com.cdac.ads.utils;

import com.cdac.ads.hashtable.HashTable;

public class PopulatedTable {
	
	public void populateStringMap() {
		//TODO
		HashTable<String> hTS = new HashTable<>();
		hTS.add(1,"S1");
		hTS.add(6,"S6");
		hTS.add(9,"S9");
		hTS.add(7,"S7");
		hTS.add(5,"S5");
		hTS.add(2,"S2"); 
		hTS.add(3,"S3"); 
		hTS.add(4,"S4");
		hTS.add(8,"S8");
		hTS.add(10,"S10");
	}
	
	public void populateIntegerMap() {
		//TODO
		HashTable<Integer> hTI = new HashTable<>();
		hTI.add(1, 1);
		hTI.add(6, 6);
		hTI.add(9, 9);
		hTI.add(7, 7);
		hTI.add(5, 5);
		hTI.add(2, 2);
		hTI.add(3, 3);
		hTI.add(4, 4);
		hTI.add(8, 8);
		hTI.add(10, 10);
	}

}
