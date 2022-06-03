/*
 * @Author: 
 * @ProjectTitle: ADS-Mini Project 
 * @ProblemStatement: Implementation of Generic Hash Table with chaining by AVL Tree
 * @Date: 01-06-2022 -> 05-06-2022
 */

package com.cdac.ads.main;

import java.util.Scanner;

public class HashAppMain {

	public static void main(String[] args) {
		header();
		try (Scanner scan = new Scanner(System.in)) {
			boolean flag = true;
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
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
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