/*
 * @Author: 
 * @ProjectTitle: ADS-Mini Project 
 * @ProblemStatement: Implementation of Generic Hash Table with chaining by AVL Tree
 * @Date: 01-06-2022 -> 05-06-2022
 */

package com.cdac.ads.main;

import java.util.Scanner;
import com.cdac.ads.hashtable.HashTable;

public class HashAppMain{

	public static void main(String[] args) {
		header();
		try (Scanner scan = new Scanner(System.in)) {
			boolean flag = true;
			HashTable<String> hashTable = new HashTable<>();
			while(flag) {
				System.out.println("\n=== Available Options ===");
				System.out.println("1. Add element in Hash Table");
				System.out.println("2. Search for an element in the table");
				System.out.println("3. Remove an element from the table");
				System.out.println("4. Display all elements");
				System.out.println("5. Exit");
				System.out.print("Enter Your Choice[1-5]: ");

				try {
					switch (Integer.parseInt(scan.nextLine())) {
					case 1:
						hashTable.add(1,"Hardik");
						hashTable.add(2,"Hik2");
						hashTable.add(3,"Hik3");
						hashTable.add(4,"Hik4");
						hashTable.add(5,"Hik5");
						hashTable.add(6,"Hik6");
						hashTable.add(7,"Hik7");
						hashTable.add(8,"Hik8");
						hashTable.add(9,"Hik9");
						hashTable.add(10,"Hik10");
						hashTable.add(11,"xx11");
						hashTable.add(12,"yy12");
						hashTable.add(13,"ardik13");
						hashTable.add(14,"rdik14");
						hashTable.add(15,"ik15");
						hashTable.add(16,"k16");
						hashTable.add(17,"Ha17");
						hashTable.add(18,"Har18");
						hashTable.add(19,"Haik19");
						hashTable.add(20,"Hak20");
						hashTable.add(21,"Hk21");
						hashTable.add(22,"Hik22");
						break;
					case 2:
						
						
						break;
					case 3:
						break;
					case 4:
						hashTable.display();
						break;
					case 5:
						System.out.print("Thank You! See you again!");
						flag = false;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	// function to add header while execution.
	public static void header() {
		System.out.println("ADS MINI PROJECT ~ Hardik(220340120083) & Joy(220340120092)");
		System.out.println("Implementation of Generic Hash Table with chaining by AVL Tree as collision handling");
		System.out.println();
		System.out.println("Project Specifications:");
		System.out.println("Key Type: String");
		System.out.println("Value: <Generic>");
		System.out.println("Default Load Factor: 0.75");
		System.out.println("Default BucketArray Size: 10");
		System.out.println("Prepopulated Elements for user convenience: n = 5");
		System.out.println();
	}
}