package com.cdac.ads.utils;

import com.cdac.ads.hashtable.HashTable;

public class PopulatedTable {
 
	public HashTable<String> populateStringMap(HashTable<String> hTS) {
		hTS.add(1,"Ajay");
		hTS.add(6,"Mahesh");
		hTS.add(3,"Kanika");
		hTS.add(7,"Sameer");
		hTS.add(13,"Harshita");
		hTS.add(17,"Alka");
		hTS.add(11,"Anurag");
		
		return hTS;
	}
 
	public HashTable<Integer> populateIntegerMap(HashTable<Integer> hTI) {
		hTI.add(1, 9876);
		hTI.add(9, 5432);
		hTI.add(19, 7331);
		hTI.add(5, 6434);
		hTI.add(15, 9935);
		
		return hTI;
	}
	
	public HashTable<Double> populateDoubleMap(HashTable<Double> hTD) {
		hTD.add(2, 9342.75);
		hTD.add(1, 3021.50);
		hTD.add(3, 4023.89);
		hTD.add(7, 6425.70);
		hTD.add(13, 9956.56);
		
		return hTD;
	}
}
