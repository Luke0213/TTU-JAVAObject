package main;

public class Account implements Comparable<Account>{
	
	private String Account_Number;
	private String Name;
	private int Balance;
	private int Deposit;
	private int Withdraw_Money;
	
	public Account( String Account_Number, String Name , int Balance , int Deposit , int Withdraw_Money ) {
		this.Account_Number = Account_Number;
		this.Name = Name;
		this.Balance = Balance;
		this.Deposit = 0;
		this.Withdraw_Money = 0;
	}
	
	public String getAccount_Number() {return Account_Number;}
	public String getName() {return Name;}
	public int getBalance() {return Balance;}
	public int getDeposit() {return Deposit;}
	public int getWithdraw_Money() {return Withdraw_Money;}
	
    public void AddBalance(int balance) { Balance += balance;}
    public void SubtractBalance(int balance) { Balance -= balance;}
    public void AddDeposit(int balance) { Deposit += balance;}
    public void AddWithdrawal(int balance) { Withdraw_Money += balance;}
    
    public int compareTo(Account other) {
        return Integer.compare(this.Balance, other.getBalance());
    }
    
    public String toString() {
        return "帳號: " + Account_Number + ", 姓名: " + Name + ", 餘額: " + Balance;
    }

}