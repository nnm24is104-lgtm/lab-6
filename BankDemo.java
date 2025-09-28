package banking;

import java.util.Scanner;

public class BankDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        String accountNo = scanner.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String name = scanner.nextLine();

        Account account = new Account(accountNo, name);

        while (true) {
            System.out.println("\nBank Menue");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = Double.parseDouble(scanner.nextLine());
                        account.deposit(depositAmount);
                        break;

                    case "2":
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = Double.parseDouble(scanner.nextLine());
                        account.withdraw(withdrawAmount);
                        break;

                    case "3":
                        account.showBalance();
                        break;

                    case "4":
                        System.out.println("Thank you for using our bank. Goodbye!");
                        scanner.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a numeric value.");
            } catch (ArithmeticException | InsufficientBalanceException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
