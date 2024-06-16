public class Checking extends BankAccount {
    private double interestRate;
    private static final double OVERDRAFT_FEE = 40.0;

    public Checking(double interestRate) {
        super();
        this.interestRate = interestRate;
    }

    @Override
    public void withdrawal(double amount) {
        if (getBalance() < amount) {
            super.withdrawal(amount + OVERDRAFT_FEE);
            System.out.println("Overdraft! An additional fee of $" + OVERDRAFT_FEE + " has been accessed.");
        } else {
            super.withdrawal(amount);
        }
    }

    public void processWithdrawal(double amount) {
        withdrawal(amount);
        System.out.println("New Balance: $" + getBalance());
    }

    public void displayAccount() {
        accountSummary();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
