
public class BankAccount {
    private String owner;
    private int password;
    private double balance;

    public BankAccount(String owner, int password, double initialBalance) {
        this.owner = owner;
        this.password = password;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
            System.out.println("Balance cannot be negative. Setting balance to 0.");
        }
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance(int inputPassword) {
        if (verifyPassword(inputPassword)) {
            return balance;
        } else {
            System.out.println("Invalid password.");
            return -1; 
        }
    }

    public void transfer(double amount, BankAccount recipient, int password) {
        if (verifyPassword(password)) {
            this.withdraw(amount, password);
            recipient.deposit(amount);
        } else {
            System.out.println("Wrong password. Transfer failed.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit: " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void deposit(double amount, int inputPassword) {
        if (verifyPassword(inputPassword)) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposit: " + amount + ". New balance: " + balance);
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        } else {
            System.out.println("Wrong password.");
        }
    }

    public void withdraw(double amount, int inputPassword) {
        if (verifyPassword(inputPassword)) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdraw: " + amount + ". New balance: " + balance);
            } else if (amount > balance) {
                System.out.println("There is not enough balance to withdraw.");
            } else {
                System.out.println("Withdrawal amount must be positive.");
            }
        } else {
            System.out.println("Wrong password.");
        }
    }

    private boolean verifyPassword(int input) {
        return this.password == input;
    }
}
