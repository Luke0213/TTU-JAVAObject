package main;

import java.util.*;
import java.util.Scanner;

public class Main {	
	public static void main(String[] args) {
			
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Input 2 number:");
		long i = scanner.nextInt();
		long j = scanner.nextInt();
		long Sum = Gcd.gcd(i,j);
		
		System.out.printf("GCD = %d , i = %d , j = %d.\n",Sum,i,j);
	}
	
}
