package main;

public class Gcd {
	
	public static long gcd(long i, long j) {
		while ( j != 0 ) {
			long temp = j;
			j = i % j;
			i = temp;
		}
		return i;
	}
	
}
