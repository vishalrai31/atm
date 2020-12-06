package atm;

import java.util.HashMap;

public class AccountManager {

    public static void displayBalance(Account account){
        System.out.println("  Your account balance is: $ "+account.getBalance());
    }

    public static Account depositBalance(Double amount, Account account){
        Double balance = account.balance;
        account.setBalance(balance+amount);
        System.out.println("$ "+amount+" deposited into account\n");
        return account;
    }

    public static Account withDrawlBalance(Double amount, Account account){
        Double balance = account.balance;
        if(balance < amount){
            System.out.println(" OOPS: You do not have sufficient balance, please deposit first\n");
        } else{
            account.setBalance(balance-amount);
        }
        return account;
    }


    public static HashMap<String, Account> initializeAccounts(){
        Account acc1= new Account();
        acc1.setAccountNo("101");
        acc1.setAccountNo("Mr. John");
        acc1.setBalance(100.0);


        Account acc2= new Account();
        acc2.setAccountNo("102");
        acc2.setAccountNo("Miss. Pratiksha");
        acc2.setBalance(50.0);

        Account acc3= new Account();
        acc3.setAccountNo("103");
        acc3.setAccountNo("Miss. Rani");
        acc3.setBalance(50.0);

        HashMap accountMap=new HashMap<String, Account>();
        accountMap.put("101", acc1);
        accountMap.put("102", acc2);
        accountMap.put("103", acc3);

        return accountMap;

    }
}
