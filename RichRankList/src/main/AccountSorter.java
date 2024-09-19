package main;

import java.util.Collections;
import java.util.List;

public class AccountSorter {
	
	public static void SortAccountAscending( List<Account> accounts ) {
		Collections.sort(accounts);
	}
	
	public static void SortAccountDescending( List<Account> accounts ) {
		Collections.sort(accounts, Collections.reverseOrder());
	}
	
}
