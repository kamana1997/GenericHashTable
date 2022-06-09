/*
 * @Author	            : Kamana Mathur [220340120097] & Udit Keskar [220340120100]
 * @ProjectTitle		: ADS-Mini Project 
 * @ProblemStatement	: Implement Generic HashTable that uses Chaining for Collision Handling
 * @Date				: 01-06-2022 -> 09-06-2022
 */

package com.cdac.ads.main;

import java.util.Scanner;

import com.cdac.ads.utils.HashTableOperations;
import com.cdac.ads.utils.PopulatedTable;
import com.cdac.ads.hashtable.HashTable;

public class HashAppMain {

	private static HashTable<Integer> hashTableInt;
	private static HashTable<String> hashTableStr;
	private static HashTable<Double> hashTableDouble;

	public static void main(String[] args) {
		header();
		PopulatedTable pT = new PopulatedTable();
		HashTableOperations op = new HashTableOperations();

		System.out.println("*****************************************************");
		System.out.print("Please choose data type for value in HashTable : \n");
		System.out.print("\n1. Integer Values");
		System.out.print("\n2. String  Values");
		System.out.print("\n3. Double  Values");
		System.out.println("\n*****************************************************");
		System.out.print("\nEnter your choice from above menu : ");

		try (Scanner scan = new Scanner(System.in)) {
			switch (Integer.parseInt(scan.nextLine())) {
			case 1:
				hashTableInt = new HashTable<Integer>();
				hashTableInt = pT.populateIntegerMap(hashTableInt);
				op.integerTable(scan, hashTableInt);
				break;

			case 2:
				hashTableStr = new HashTable<String>();
				hashTableStr = pT.populateStringMap(hashTableStr);
				op.stringTable(scan, hashTableStr);
				break;

			case 3:
				hashTableDouble = new HashTable<Double>();
				hashTableDouble = pT.populateDoubleMap(hashTableDouble);
				op.doubleTable(scan, hashTableDouble);
				break;

			default:
				System.out.println("Invalid choice..!!\nApplication Ended..!!");
			}
		}
	}

	// function to add header while execution.
	public static void header() {
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("| ADS MINI PROJECT ~ Kamana(220340120097) & Udit(220340120100)                          |");
		System.out.println("|                                                                                      |");
		System.out.println("| Implementation of Generic Hash Table that uses chaining for collision handling,      |");
		System.out.println("| where we implemented chaining using AVL tree.                                        |");
		System.out.println("|                                                                                      |");
		System.out.println("| Project Specifications:                                                              |");
		System.out.println("| # Key Type                                    : Integer                              |");
		System.out.println("| # Value                                       : <Generic>                            |");
		System.out.println("| # Default Load Factor	                        : 0.75                                 |");
		System.out.println("| # Default BucketArray Size                    : 10                                   |");
		System.out.println("| # Prepopulated Elements for user convenience  : n = 5                                |");
		System.out.println("|                                                                                      |");
		System.out.println("----------------------------------------------------------------------------------------");
	}
}