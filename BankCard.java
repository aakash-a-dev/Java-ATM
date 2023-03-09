public class BankCard {
    private String cardNumber;
    private int pin;
    
    public BankCard(String cardNumber, int pin) {
        this.cardNumber = cardNumber;
        this.pin = pin;
    }
    
    public String getCardNumber() {
        return cardNumber;
    }
    
    public boolean validatePin(int enteredPin) {
        return pin == enteredPin;
    }
    
    public void setPin(int newPin) {
        this.pin = newPin;
    }

    public int getPin() {
        return pin;
    }
}
