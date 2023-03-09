public class Customer {
    private String name;
    private BankCard bankCard;
    private BankAccount bankAccount;
    
    public Customer(String name, BankCard bankCard, BankAccount bankAccount) {
        this.name = name;
        this.bankCard = bankCard;
        this.bankAccount = bankAccount;
    }
    
    public String getName() {
        return name;
    }
    
    public BankCard getBankCard() {
        return bankCard;
    }
    
    public BankAccount getBankAccount() {
        return bankAccount;
    }
}
