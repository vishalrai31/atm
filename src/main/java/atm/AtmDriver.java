package atm;

import java.util.HashMap;
import java.util.Scanner;

public class AtmDriver {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String [] str){
        String accountNo;
        int menuChoice=0;
        HashMap<String, Account> accountsMap= AccountManager.initializeAccounts();
        System.out.println("\n ** Welcome to MMM Bank **\n\n");
        System.out.println("Please enter your account no to continue and press enter");
        accountNo = scanner.next();
        if(!accountsMap.containsKey(accountNo)){
            System.out.println("\n ** Entered account is not present with Bank, please get it opened ***");
            System.exit(0);
        }
        while (menuChoice != 4) {
            menuChoice = menu();
            Account account= accountsMap.get(accountNo);
            switch (menuChoice) {
                case 1:
                    AccountManager.displayBalance(account);
                    break;
                case 2:
                    System.out.println("Please enter amount want to deposit and press enter\n");
                    Double amount = Double.parseDouble(scanner.next());
                    Account changedAccount = AccountManager.depositBalance(amount,account);
                    accountsMap.put(accountNo, changedAccount);
                    break;
                case 3:
                    System.out.println("Please enter amount want to withdrawl and press enter\n");
                    Double withDrwalAmount = Double.parseDouble(scanner.next());
                    Account withdrawlAccount = AccountManager.withDrawlBalance(withDrwalAmount,account);
                    accountsMap.put(accountNo, withdrawlAccount);
                    break;
                case 4:
                    System.out.println("\n ** Thanks for choosing MMM Bank **\n *** Good Bye ***");
                    System.exit(0);
                    break;
            }
        }



    }


    public static int menu()
    {
        int menuChoice;
        do
        {
            System.out.print("\nPlease Choose From the Following Options:"
                    + "\n 1. Display Balance \n 2. Deposit"
                    + "\n 3. Withdraw\n 4. Log Out\n\n");
            menuChoice = scanner.nextInt();
            if (menuChoice < 1 || menuChoice > 4){
                System.out.println("** Invalid option **");
            }
        }while (menuChoice < 1 || menuChoice > 4);

        return menuChoice;
    }
}
