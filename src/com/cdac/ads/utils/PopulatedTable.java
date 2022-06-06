package com.cdac.ads.utils;

import com.cdac.ads.hashtable.HashTable;

public class PopulatedTable {

	//TODO @Udit please make populating data.  
	public HashTable<String> populateStringMap(HashTable<String> hTS) {
		hTS.add(1,"S1");
		hTS.add(6,"S6");
		
		return hTS;
	}

	//TODO @Udit please make populating data.  
	public HashTable<Integer> populateIntegerMap(HashTable<Integer> hTI) {

		hTI.add(1, 1);
		hTI.add(9, 9);
		
		return hTI;
	}
	
	//TODO @Udit please make populate double.
	public HashTable<Double> populateDoubleMap(HashTable<Double> hTD) {
		return hTD;
	}
}