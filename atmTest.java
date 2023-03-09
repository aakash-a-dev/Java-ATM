public class atmTest {
    public static void main(String[] args) {
        BankCard bankCard = new BankCard("1234 5678 9012 3456", 1234);
        BankAccount bankAccount = new BankAccount("Jasmeen", 123456789, 1000.0);
        Customer customer = new Customer("Jasmeen", bankCard, bankAccount);
        ATM atm = new ATM(customer);
        atm.start();
    }
}
