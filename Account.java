package banking;

public class Account {
    private String accountNo;
    private String name;
    private double balance;

    public Account(String accountNo, String name) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = 0.0;
    }

    public void deposit(double amount) throws ArithmeticException {
        if (amount <= 0) {
            throw new ArithmeticException("Deposit amount must be positive.");
        }
        balance += amount;
        System.out.println("Deposited: " + amount + " New balance: " + balance);
    }

    public void withdraw(double amount) throws ArithmeticException, InsufficientBalanceException {
        if (amount <= 0) {
            throw new ArithmeticException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance for withdrawal.");
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount + " New balance: " + balance);
    }

    public void showBalance() {
        System.out.println("Account Number: " + accountNo + 
                           " | Name: " + name + 
                           " | Balance: " + balance);
    }
}

