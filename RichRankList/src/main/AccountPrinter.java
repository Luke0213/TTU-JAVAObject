package main;

import java.util.List;

public class AccountPrinter {

    public static void PrintAccount(List<Account> accounts) {
        for (Account account : accounts) {
            System.out.println(PrintAccountDetails(account));
        }
    }

    public static String PrintAccountDetails(Account account) {
        return "帳號:" + account.getAccount_Number() + "\n姓名: " + account.getName() + "\n餘額: " + account.getBalance();
    }
   }