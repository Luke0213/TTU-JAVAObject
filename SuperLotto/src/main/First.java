package main;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class First {
	
	public static int[] GenerateRandom_LinkedList( int size , int min , int max ) {
		
		LinkedList<Integer> LinkedListNumber = new LinkedList<>();
		int[] LinkedListArray = new int[size];
		
		for( int i = min ; i <= max ; i++ ) {
			LinkedListNumber.add(i);
		}
		
		for( int i = 0 ; i < size ; i++ ) {
			if(!LinkedListNumber.isEmpty()) {
				int Array = (int) (Math.random() * LinkedListNumber.size());
				LinkedListArray[i] = LinkedListNumber.remove(Array);
			}
		}
		return LinkedListArray;
	}
	
	public static int FirstAwardNumber( int[] First_Number , int[] RandomNumbers_LinkedList ) {
		
		Set<Integer> AwardNumber = new HashSet<>();
		for( int i : First_Number ) {
			AwardNumber.add(i);
		}
		
		int count = 0;
		
		for( int i : RandomNumbers_LinkedList ) {
			if(AwardNumber.contains(i)) {
				count++;
				AwardNumber.remove(i);
			}
		}
		return count;
	}

}
