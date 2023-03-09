import java.util.Scanner;

public class ATM {
    private BankAccount bankAccount;
    private BankCard bankCard;
    private Customer customer;
    private static final int MAX_ATTEMPTS = 5;
    
    public ATM(Customer customer) {
        this.customer = customer;
        this.bankCard = customer.getBankCard();
        this.bankAccount = customer.getBankAccount();
    }
    
    public void start() {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        while (attempts < 5) {
            System.out.print("Enter your PIN: ");
            int pin = scanner.nextInt();
            if (bankCard.validatePin(pin)) {
                break;
            }
            attempts++;
            System.out.println("Invalid PIN. Please try again.");
        }
        if (attempts == 5) {
            System.out.println("Too many incorrect attempts. The ATM will now exit.");
            return;
        }
        System.out.println("Welcome to Bank of NC");
        boolean continueLoop = true;
        while (continueLoop) {
            System.out.println("Please choose an option:");
            System.out.println("1. Display account information");
            System.out.println("2. Withdraw funds");
            System.out.println("3. Deposit funds");
            System.out.println("4. Change PIN");
            System.out.println("5. Exit");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    displayAccountInfo();
                    break;
                case 2:
                    withdrawFunds();
                    break;
                case 3:
                    depositFunds();
                    break;
                case 4:
                    changePIN();
                    break;
                case 5:
                    continueLoop = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
            if (continueLoop) {
                System.out.print("Would you like to do anything else today? (yes or no) ");
                String response = scanner.next();
                if (response.equalsIgnoreCase("no")) {
                    continueLoop = false;
                }
            }
        }
        System.out.println("Thank you for using Bank of NC. Goodbye!");
    }

    private void displayAccountInfo() {
        System.out.println("Account Number: " + bankAccount.getAccountNumber());
        System.out.println("Current Balance: $" + bankAccount.getBalance());
    }

    private void withdrawFunds() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();
        bankAccount.withdraw(amount);
    }

    public void depositFunds() {
        Scanner input = new Scanner(System.in);
        System.out.println("Which account would you like to deposit to?");
        System.out.println("1) Chequing - " + bankAccount.getAccountNumber() + " - Current Balance: $" + bankAccount.getBalance());
        System.out.println("2) Savings - " + bankAccount.getAccountNumber() + " - Current Balance: $" + bankAccount.getBalance());
        int choice = input.nextInt();
        BankAccount account = null;
        if (choice == 1) {
            account = bankAccount;
        } else if (choice == 2) {
            account = bankAccount;
        } else {
            System.out.println("Invalid choice.");
            return;
        }
        System.out.println("How much would you like to deposit?");
        double amount = input.nextDouble();
        if (amount > 10000) {
            System.out.println("Deposit amount cannot exceed $10,000.");
            return;
        }
        account.deposit(amount);
        System.out.println("Deposit successful.");
        System.out.println("New balance: $" + account.getBalance());
    }

    private void changePIN() {
            Scanner scanner = new Scanner(System.in);

    // prompt for current PIN
    int attempts = 0;
    int currentPin;
    do {
        System.out.print("Enter current PIN: ");
        currentPin = scanner.nextInt();
        attempts++;
        if (attempts == 5) {
            System.out.println("Too many incorrect attempts. Exiting...");
            System.exit(0);
        }
    } while (currentPin != this.bankCard.getPin());

    // prompt for new PIN
    int newPin;
    do {
        System.out.print("Enter new PIN (4-6 digits): ");
        newPin = scanner.nextInt();
    } while (newPin < 1000 || newPin > 999999);

    // confirm new PIN
    int confirmPin;
    do {
        System.out.print("Confirm new PIN: ");
        confirmPin = scanner.nextInt();
        if (confirmPin != newPin) {
            System.out.println("PINs do not match. Please try again.");
        }
    } while (confirmPin != newPin);

    // update bank card PIN
    this.bankCard.setPin(newPin);
    System.out.println("PIN successfully changed.");
    }
}
