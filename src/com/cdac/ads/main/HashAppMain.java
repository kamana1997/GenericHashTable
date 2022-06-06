/*
 * @Author: 
 * @ProjectTitle: ADS-Mini Project 
 * @ProblemStatement: Implementation of Generic Hash Table with chaining by AVL Tree
 * @Date: 01-06-2022 -> 05-06-2022
 */

package com.cdac.ads.main;

import java.util.Scanner;

import com.cdac.ads.utils.HashTableOperations;
import com.cdac.ads.utils.PopulatedTable;
import com.cdac.ads.hashtable.HashTable;

public class HashAppMain{
	
	private static HashTable<Integer> hashTableInt;
	private static HashTable<String> hashTableStr;
	private static HashTable<Double> hashTableDouble;
	
	public static void main(String[] args) {
		header();
		PopulatedTable pT = new PopulatedTable();
		HashTableOperations op = new HashTableOperations();
		
		System.out.println("Please Choose Type Of value in HashTable");
		System.out.println("1. Integer Values");
		System.out.println("2. String Values");
		System.out.println("3. Double Values");
		System.out.print("Enter Your Choice: ");

		try(Scanner scan = new Scanner(System.in)){
			System.out.println();
			switch(Integer.parseInt(scan.nextLine())) {
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
				System.out.println("Enter valid choice");
			}
		}
	}

	// function to add header while execution.
	public static void header() {
		System.out.println("ADS MINI PROJECT ~ Hardik(220340120083) & Joy(220340120092)");
		System.out.println("Implementation of Generic Hash Table with chaining by AVL Tree as collision handling");
		System.out.println();
		System.out.println("Project Specifications:");
		System.out.println("Key Type: Integer");
		System.out.println("Value: <Generic>");
		System.out.println("Default Load Factor: 0.75");
		System.out.println("Default BucketArray Size: 5");
		System.out.println("Prepopulated Elements for user convenience: n = 2");
		System.out.println();
	}
}