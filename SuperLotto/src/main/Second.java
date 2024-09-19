package main;

import java.util.HashSet;
import java.util.Set;

public class Second {
	
	public static int[] GenerateRandom_HashSet( int size , int min , int max ) {
		
		int[] HashSetArray = new int[size];
		Set<Integer> HashSetNumber = new HashSet<>();
		
		while( HashSetNumber.size() < size ) {
				int Array = (int) ( Math.random() * ( max - min + 1 )) + min ;
				HashSetNumber.add(Array);
		}
		
		int i = 0;
		for( int number : HashSetNumber ) {
			HashSetArray[i++] = number; 
		}
		
		return HashSetArray;
	}
	


	public static int SecondAwardNumber( int[] Second_Number , int[] RandomNumbers_HashSet ) {
		
		Set<Integer> AwardNumber = new HashSet<>();
		for( int i : Second_Number ) {
			AwardNumber.add(i);
		}
		
		int count = 0;
		
		for( int i : RandomNumbers_HashSet ) {
			if(AwardNumber.contains(i)) {
				count++;
				AwardNumber.remove(i);
			}
		}
		return count;
	}

}
