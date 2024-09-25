package main;

public class Prize {
	
	public static String PrizeNumber( int[] First_Number , int[] Second_Number , int[] RandomNumbers_LinkedList , int[]RandomNumbers_HashSet ) {
		
		int FristPrizeNumber = First.FirstAwardNumber(First_Number, RandomNumbers_LinkedList);
		int SecondPrizeNumer = Second.SecondAwardNumber(Second_Number, RandomNumbers_HashSet);
		
		if( FristPrizeNumber == 1 && SecondPrizeNumer >= 1 ) {
			return "普獎";
		}if( FristPrizeNumber == 3 && SecondPrizeNumer == 0 ) {
			return "玖獎";
		}if( FristPrizeNumber == 2 && SecondPrizeNumer >= 1 ) {
			return "捌獎";
		}if( FristPrizeNumber == 3 && SecondPrizeNumer >= 1 ) {
			return "柒獎";
		}if( FristPrizeNumber == 4 && SecondPrizeNumer == 0 ) {
			return "陸獎";
		}if( FristPrizeNumber == 4 && SecondPrizeNumer >= 1 ) {
			return "伍獎";
		}if( FristPrizeNumber == 5 && SecondPrizeNumer == 0 ) {
			return "肆獎";
		}if( FristPrizeNumber == 5 && SecondPrizeNumer >= 1 ) {
			return "參獎";
		}if( FristPrizeNumber == 6 && SecondPrizeNumer == 0 ) {
			return "貳獎";
		}if( FristPrizeNumber == 6 && SecondPrizeNumer >= 1 ) {
			return "頭獎";
		}else {
			return "未中獎";
		}
		
	}
}
