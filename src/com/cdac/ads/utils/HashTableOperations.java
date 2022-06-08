/*
 * @Author				: Hardik Agarwal [220340120083] & Joy Pahari [220340120092]
 * @ProjectTitle		: ADS-Mini Project 
 * @ProblemStatement	: Implement Generic HashTable that uses Chaining for Collision Handling
 * @Date				: 01-06-2022 -> 09-06-2022
 */

package com.cdac.ads.utils;

import java.util.Scanner;

import com.cdac.ads.customexception.HashTableCustomException;
import com.cdac.ads.hashtable.HashTable;

public class HashTableOperations {

	// Execute when user selects data type for value as Integer.
	public void integerTable(Scanner scan, HashTable<Integer> hashTable) {
		boolean flag = true;
		while (flag) {
			// Menu() provides options
			menu();

			try {
				switch (Integer.parseInt(scan.nextLine())) {
				case 1:

					System.out.print("\n--> Enter key to be added : ");
					Integer key = Integer.parseInt(scan.nextLine());
					System.out.println();
					System.out.print("--> Enter value at key : ");
					Integer value = Integer.parseInt(scan.nextLine());

					// Check if key already exists.
					// If key doesn't exist add key to table.
					// Else update value present at key.
					if (!hashTable.checkDuplicateKeyUpdateValue(key, value)) {
						hashTable.add(key, value);
						System.out.println("\nKey added successfully..!!");
					} else {
						throw new HashTableCustomException("\nKey (" + key + ") already exists..!!\nUpdated value.");
					}
					break;

				case 2:
					System.out.print("--> Enter key to be searched : ");
					Integer valueReturn = hashTable.searchKeyValue(Integer.parseInt(scan.nextLine()), null);
					System.out.println();

					// Check if key exists.
					// If key exist return value present at key.
					if (valueReturn != null) {
						System.out.println("Key Found!!\nValue at key = " + valueReturn);
					} else {
						throw new HashTableCustomException("Sorry..!!\nKey Does Not Exist..!!");
					}
					break;

				case 3:
					System.out.print("--> Enter key to be deleted : ");
					Integer keyDelete = Integer.parseInt(scan.nextLine());
					System.out.println();
					Integer valueDelete = hashTable.searchKeyValue(keyDelete, null);

					// Check if key exists.
					// If key exist delete value present at key.
					if (valueDelete != null) {
						System.out.println("Key Found!!\nValue at key = " + valueDelete);
						hashTable.removeNodeFromTable(keyDelete);
						System.out.println("Element deleted successfully..!!");
					} else {
						throw new HashTableCustomException("Sorry..!!\nKey Does Not Exist..!!");
					}
					break;

				case 4:
					hashTable.display();
					break;

				case 5:
					System.out.print("\nApplication Ended..!!\nThank You for using..!!");
					flag = false;
					break;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	// Execute when user selects data type for value as String.
	public void stringTable(Scanner scan, HashTable<String> hashTable) {
		boolean flag = true;
		while (flag) {
			// Menu() provides options
			menu();

			try {
				switch (Integer.parseInt(scan.nextLine())) {
				case 1:

					System.out.print("--> Enter key to be added : ");
					Integer key = Integer.parseInt(scan.nextLine());
					System.out.println();
					System.out.print("--> Enter value at key : ");
					String value = scan.nextLine();

					// Check if key already exists.
					// If key doesn't exist add key to table.
					// Else update value present at key.
					if (!hashTable.checkDuplicateKeyUpdateValue(key, value)) {
						hashTable.add(key, value);
						System.out.println("\nKey added successfully..!!");
					} else {
						throw new HashTableCustomException("\nKey (" + key + ") already exists..!!\nUpdated value.");
					}
					break;

				case 2:

					System.out.print("--> Enter key to be searched : ");
					String valueReturn = hashTable.searchKeyValue(Integer.parseInt(scan.nextLine()), null);
					System.out.println();

					// Check if key exists.
					// If key exist return value present at key.
					if (valueReturn != null) {
						System.out.println("Key Found!!\nValue at key = " + valueReturn);
					} else {
						throw new HashTableCustomException("Sorry..!!\nKey Does Not Exist..!!");
					}
					break;

				case 3:
					System.out.print("--> Enter key to be deleted : ");
					Integer keyDelete = Integer.parseInt(scan.nextLine());
					System.out.println();
					String valueDelete = hashTable.searchKeyValue(keyDelete, null);

					// Check if key exists.
					// If key exist delete value present at key.
					if (valueDelete != null) {
						System.out.println("Key Found!!\nValue at key = " + valueDelete);
						hashTable.removeNodeFromTable(keyDelete);
						System.out.println("Element deleted successfully..!!");
					} else {
						throw new HashTableCustomException("Sorry..!!\nKey Does Not Exist..!!");
					}
					break;

				case 4:
					hashTable.display();
					break;

				case 5:
					System.out.print("\nApplication Ended..!!\nThank You for using..!!");
					flag = false;
					break;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	// Execute when user selects data type for value as Double.
	public void doubleTable(Scanner scan, HashTable<Double> hashTable) {
		boolean flag = true;
		while (flag) {
			// Menu() provides options
			menu();

			try {
				switch (Integer.parseInt(scan.nextLine())) {
				case 1:

					System.out.print("-->Enter key to be added : ");
					Integer key = Integer.parseInt(scan.nextLine());
					System.out.println();
					System.out.print("-->Enter value at key : ");
					Double value = Double.parseDouble(scan.nextLine());

					// Check if key already exists. If key doesn't exist add key to table, Else
					// update value at key.
					if (!hashTable.checkDuplicateKeyUpdateValue(key, value)) {
						hashTable.add(key, value);
						System.out.println("\nKey added successfully..!!");
					} else {
						throw new HashTableCustomException("\nKey (" + key + ") already exists..!!\nUpdated value.");
					}
					break;

				case 2:
					System.out.print("--> Enter key to be searched : ");
					Double valueReturn = hashTable.searchKeyValue(Integer.parseInt(scan.nextLine()), null);
					System.out.println();

					// Check if key exists.
					// If key exist return value present at key.
					if (valueReturn != null) {
						System.out.println("Key Found!!\nValue at key = " + valueReturn);
					} else {
						throw new HashTableCustomException("Sorry..!!\nKey Does Not Exist..!!");
					}
					break;

				case 3:
					System.out.print("--> Enter key to be deleted : ");
					Integer keyDelete = Integer.parseInt(scan.nextLine());
					System.out.println();
					Double valueDelete = hashTable.searchKeyValue(keyDelete, null);

					// Check if key exists.
					// If key exist delete value present at key.
					if (valueDelete != null) {
						System.out.println("Key Found!!\nValue at key = " + valueDelete);
						hashTable.removeNodeFromTable(keyDelete);
						System.out.println("Element deleted successfully..!!");
					} else {
						throw new HashTableCustomException("Sorry..!!\nKey Does Not Exist..!!");
					}
					break;

				case 4:
					hashTable.display();
					break;

				case 5:
					System.out.print("\nApplication Ended..!!\nThank You for using..!!");
					flag = false;
					break;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void menu() {
		System.out.println("");
		System.out.println("********** Available Options **********");
		System.out.println("1. Add element in Hash Table");
		System.out.println("2. Search for an element in the table");
		System.out.println("3. Remove an element from the table");
		System.out.println("4. Display all elements");
		System.out.println("5. Exit");
		System.out.println("***************************************");
		System.out.println();
		System.out.print("Enter your choice [1-5] from above menu : ");
	}
}
