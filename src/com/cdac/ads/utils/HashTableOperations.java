package com.cdac.ads.utils;

import java.util.Scanner;

import com.cdac.ads.customexception.HashTableCustomException;
import com.cdac.ads.hashtable.HashTable;

public class HashTableOperations<T> {
	public void integerTable(Scanner scan, HashTable<Integer> hashTable) {
		boolean flag = true;
		while (flag) {
			menu();

			try {
				switch (Integer.parseInt(scan.nextLine())) {
				case 1:

					System.out.println("Enter Key");
					Integer key = Integer.parseInt(scan.nextLine());
					System.out.println("Enter Value");
					Integer value = Integer.parseInt(scan.nextLine());

					if (!hashTable.checkDuplicateKeyUpdateValue(key,value)) {
						hashTable.add(key, value);
					}else {
						throw new HashTableCustomException("Exisiting Value at "+key+" updated.");
					}
					break;

				case 2:
					System.out.println("Enter key to be searched");
					Integer valueReturn = hashTable.searchKeyValue(Integer.parseInt(scan.nextLine()),null);
					if(valueReturn != null) {
						System.out.println("Key Found! Value = " + valueReturn);
					}else {
						throw new HashTableCustomException("Key Does Not Exist");
					}
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
				System.out.println(e.getMessage());
			}
		}
	}

	public void stringTable(Scanner scan, HashTable<String> hashTable) {
		boolean flag = true;
		while (flag) {
			menu();

			try {
				switch (Integer.parseInt(scan.nextLine())) {
				case 1:

					System.out.println("Enter Key");
					Integer key = Integer.parseInt(scan.nextLine());
					System.out.println("Enter Value");
					String value = scan.nextLine();
					
					if (!hashTable.checkDuplicateKeyUpdateValue(key,value)) {
						hashTable.add(key,value);
					} else {
						throw new HashTableCustomException("Exisiting Value at "+key+" updated.");
					}
					break;
				
				case 2:
					
					System.out.println("Enter key to be searched");
					String valueReturn = hashTable.searchKeyValue(Integer.parseInt(scan.nextLine()),null);
					
					if(valueReturn != null) {
						System.out.println("Key Found! Value = " + valueReturn);
					}else {
						throw new HashTableCustomException("Key Does Not Exist");
					}
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
				System.out.println(e.getMessage());
			}
		}
	}

	public void doubleTable(Scanner scan, HashTable<Double> hashTable) {
		boolean flag = true;
		while (flag) {
			menu();

			try {
				switch (Integer.parseInt(scan.nextLine())) {
				case 1:

					System.out.println("Enter Key");
					Integer key = Integer.parseInt(scan.nextLine());
					System.out.println("Enter Value");
					
					Double value = Double.parseDouble(scan.nextLine());
					if (!hashTable.checkDuplicateKeyUpdateValue(key,value)) {
						hashTable.add(key,value);
					} else {
						throw new HashTableCustomException("Exisiting Value at "+key+" updated.");
					}
					break;
				
				case 2:
					System.out.println("Enter key to be searched");
					Double valueReturn = hashTable.searchKeyValue(Integer.parseInt(scan.nextLine()),null);
					
					if(valueReturn != null) {
						System.out.println("Key Found! Value = " + valueReturn);
					}else {
						throw new HashTableCustomException("Key Does Not Exist");
					}
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
				System.out.println(e.getMessage());
			}
		}
	}

	public void menu() {
		System.out.println("\n=== Available Options ===");
		System.out.println("1. Add element in Hash Table");
		System.out.println("2. Search for an element in the table");
		System.out.println("3. Remove an element from the table");
		System.out.println("4. Display all elements");
		System.out.println("5. Exit");
		System.out.print("Enter Your Choice[1-5]: ");
	}
}
