/*
 * @Author				: Kamana Mathur [220340120097] & Udit Keskar [220340120100]
 * @ProjectTitle		: ADS-Mini Project 
 * @ProblemStatement	: Implement Generic HashTable that uses Chaining for Collision Handling
 * @Date				: 01-06-2022 -> 09-06-2022
 */

package com.cdac.ads.utils;

import com.cdac.ads.hashtable.HashTable;

public class PopulatedTable {

	// Populated data for string type values
	public HashTable<String> populateStringMap(HashTable<String> hTS) {
		// hTS.add(key(Integer), value(String))
		hTS.add(6, "Mahesh");
		hTS.add(23, "Kanika");
		hTS.add(7, "Sameer");
		hTS.add(13, "Harshita");
		hTS.add(33, "Harshita");

		return hTS;
	}

	// Populated data for integer type values
	public HashTable<Integer> populateIntegerMap(HashTable<Integer> hTI) {
		// hTI.add(key(Integer), value(Integer))
		hTI.add(1, 9876);
		hTI.add(19, 7331);
		hTI.add(9, 5432);
		hTI.add(29, 6434);
		hTI.add(15, 9935);

		return hTI;
	}

	// Populated data for double type values
	public HashTable<Double> populateDoubleMap(HashTable<Double> hTD) {
		// hTI.add(key(Integer), value(Double))
		hTD.add(2, 9342.75);
		hTD.add(12, 3021.50);
		hTD.add(22, 4023.89);
		hTD.add(32, 6425.70);
		hTD.add(13, 9956.56);

		return hTD;
	}
}
