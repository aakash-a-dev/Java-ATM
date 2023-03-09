public class BankAccount {
    private String accountHolderName;
    private int accountNumber;
    private double balance;
    
    public BankAccount(String accountHolderName, int accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }
    
    public void deposit(double amount) {
        balance += amount;
        System.out.println("$" + amount + " deposited successfully.");
        System.out.println("Your new balance is $" + balance);
    }
    
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("$" + amount + " withdrawn successfully.");
            System.out.println("Your new balance is $" + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }
    
    public double getBalance() {
        return balance;
    }
}
