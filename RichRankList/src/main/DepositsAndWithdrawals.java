package main;

public class DepositsAndWithdrawals {
	
	public void DepositMoney(Account account,int balance) {
		account.AddBalance(balance);
		account.AddDeposit(balance);
	}
	
	public void WithdrawMoney(Account account,int balance) {
		if ( account.getBalance() >= balance ) {
            account.SubtractBalance(balance);  
            account.AddWithdrawal(balance); 
        } else {
            System.out.println("餘額不足，無法提款！");
        }
	}
}
