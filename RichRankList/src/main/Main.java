package main;

import java.util.TreeMap;
import java.util.Scanner;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		TreeMap<String, Account> AccountMap = new TreeMap<>();
		DepositsAndWithdrawals Operations = new DepositsAndWithdrawals();
		
		while(true) {
			
			System.out.println("是否輸入銀行帳號資料(Y/N)");
			String i = scanner.nextLine();
			
			if(i.equalsIgnoreCase("Y")) {
				
				System.out.print("請輸入帳號: ");
				String accountNumber = scanner.nextLine();
				
				System.out.print("請輸入姓名: ");
	            String name = scanner.nextLine();
	            
	            System.out.print("請輸入餘額: ");
	            int balance = Integer.parseInt(scanner.nextLine());
	            
	            Account account = new Account(accountNumber,name,balance,0,0);
	            AccountMap.put(accountNumber,account);
	            
	            while(true) {
	            	System.out.println("請選擇操作: 1) 存款 2) 提款 3) 結束");
                    int choice = Integer.parseInt(scanner.nextLine());
                    
                    if( choice == 1 ) {
                    	System.out.print("請輸入存款金額: ");
        	            int deposit = Integer.parseInt(scanner.nextLine());
        	            Operations.DepositMoney(account,deposit);
                    }
                    else if( choice == 2 ) {
        	            System.out.print("請輸入提款金額: ");
        	            int withdrawMoney = Integer.parseInt(scanner.nextLine());
        	            Operations.WithdrawMoney(account,withdrawMoney);
                    }else if( choice == 3 ) {
                    	break;
                    }
	            }
			}
			else if(i.equalsIgnoreCase("N")) {
				break;
			}
		}
		 System.out.println("\n所有帳戶資料:");
	     for (String AccountNumber : AccountMap.keySet()) {
	    	 	Account acc = AccountMap.get(AccountNumber);
	    	 	System.out.println(acc);
	    	 	System.out.println("---------------------------");
	    	 }
	     
	     List<Account> accounts = new ArrayList<>(AccountMap.values());

	     System.out.println("\n帳戶資料（升序排列）:");
	     AccountSorter.SortAccountAscending(accounts);
	     for (Account account : accounts) {
	    	 System.out.println(account);
	     }

	     System.out.println("\n帳戶資料（降序排列）:");
	     AccountSorter.SortAccountDescending(accounts);		
	     for (Account account : accounts) {	
	    	 System.out.println(account);
	     }

	     scanner.close();
	}
}
