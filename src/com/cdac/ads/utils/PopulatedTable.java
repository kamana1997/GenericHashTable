package com.cdac.ads.utils;

import com.cdac.ads.hashtable.HashTable;

public class PopulatedTable {

	//TODO @Udit please make populating data.  
	public HashTable<String> populateStringMap(HashTable<String> hTS) {
		hTS.add(1,"Joy");
		hTS.add(6,"Hardik");
		
		return hTS;
	}

	//TODO @Udit please make populating data.  
	public HashTable<Integer> populateIntegerMap(HashTable<Integer> hTI) {
		hTI.add(1, 9876);
		hTI.add(9, 5432);
		
		return hTI;
	}
	
	//TODO @Udit please make populate double.
	public HashTable<Double> populateDoubleMap(HashTable<Double> hTD) {
		hTD.add(2, 9342.75);
		hTD.add(1, 3021.50);
		
		return hTD;
	}
}