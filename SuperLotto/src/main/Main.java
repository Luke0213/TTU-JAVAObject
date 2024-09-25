package main;

import java.util.Scanner;

public class Main {

	public static void PrintArray(int[] array) {
		for( int num : array ) {
			System.out.print(num+ " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int[] RandomNumbers_LinkedList = First.GenerateRandom_LinkedList( 6 , 1 , 38 );
		int[] RandomNumbers_HashSet = Second.GenerateRandom_HashSet( 3 , 1 , 8 );
		int[] First_Number = new int[6];
		int[] Second_Number = new int[3];
		
		System.out.println("產生一區號碼)");
		PrintArray(RandomNumbers_LinkedList);
		System.out.println("產生二區號碼)");
		PrintArray(RandomNumbers_HashSet);

		System.out.println("請輸入第一區號碼:");
		System.out.print("->");
		for( int i = 0 ; i < 6 ; i++ ) {
			First_Number[i] = scanner.nextInt();
		}
		
		System.out.println("請輸入第二區號碼:");
		System.out.print("->");
		for( int i = 0 ; i < 3 ; i++ ) {
			Second_Number[i] = scanner.nextInt();
		}
		
		scanner.close();
		
		int FirstFinalNumber = First.FirstAwardNumber(First_Number,RandomNumbers_LinkedList);
		System.out.println("一區中獎數為" + FirstFinalNumber + "個");
		
		int SecondFinalNumber = Second.SecondAwardNumber(Second_Number,RandomNumbers_HashSet);
		System.out.println("二區中獎數為" + SecondFinalNumber + "個");
		
		String prize = Prize.PrizeNumber(First_Number,Second_Number,RandomNumbers_LinkedList,RandomNumbers_HashSet);
		System.out.println("結果:" +prize);
		
	}
}
