import java.util.Random;

// Execute Tests for BankingAccount & Checking classes
// Tests for Both Bank Account && Checking
// set Names
// set accountIDs
// deposit some amount.
// print summary
public class Main {
    public static void main(String[] args) {
        // Execute tests for Bank Account class
        BankAccount account1 = new BankAccount();
        account1.setFirstName("Mark");
        account1.setLastName("Norem");
        account1.setAccountID(12345);
        account1.deposit(Math.random() * 1000);
        account1.accountSummary();

        System.out.println();

        // Execute tests for Checking subclass
        Checking account2 = new Checking(1.5);
        account2.setFirstName("Stella");
        account2.setLastName("Dog");
        account2.setAccountID(12356);
        account2.deposit(Math.random() * 1000);
        account2.displayAccount();
        System.out.println();

        account2.processWithdrawal(Math.random() * 100);
        System.out.println();

        account2.processWithdrawal(Math.random() * 100);
        System.out.println();

        account2.displayAccount();
    }
}
