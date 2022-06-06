package com.cdac.ads.utils;

import java.util.Scanner;

import com.cdac.ads.customexception.HashTableCustomException;
import com.cdac.ads.hashtable.HashTable;

public class HashTableOperations {
	public void integerTable(Scanner scan, HashTable<Integer> hashTable) {
		boolean flag = true;
		while (flag) {
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

					System.out.println("Enter Key");
					Integer key = Integer.parseInt(scan.nextLine());
					if (!hashTable.checkForDuplicateKey(key)) {
						System.out.println("Enter Value");
						hashTable.add(key, Integer.parseInt(scan.nextLine()));
					} else {
						throw new HashTableCustomException("Duplicate Element Fount & Not Added !!!");
					}
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

	public void stringTable(Scanner scan, HashTable<String> hashTable) {
		boolean flag = true;
		while (flag) {
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

					System.out.println("Enter Key");
					Integer key = Integer.parseInt(scan.nextLine());
					if (!hashTable.checkForDuplicateKey(key)) {
						System.out.println("Enter Value");
						hashTable.add(key,scan.nextLine());
					} else {
						throw new HashTableCustomException("Duplicate Element Fount & Not Added !!!");
					}
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

	public void doubleTable(Scanner scan, HashTable<Double> hashTable) {
		boolean flag = true;
		while (flag) {
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

					System.out.println("Enter Key");
					Integer key = Integer.parseInt(scan.nextLine());
					if (!hashTable.checkForDuplicateKey(key)) {
						System.out.println("Enter Value");
						hashTable.add(key, Double.parseDouble(scan.nextLine()));
					} else {
						throw new HashTableCustomException("Duplicate Element Fount & Not Added !!!");
					}
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
