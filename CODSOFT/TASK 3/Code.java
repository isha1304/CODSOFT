import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public boolean deposit(double amount) {
        if(amount>0){
          balance += amount;
          return true;
        } else {
           return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
    
        while (true) {
            System.out.println("ATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Exiting");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            scanner.close();
        }
    }

    private void checkBalance() {
        System.out.printf("Your current balance is: Rs %.2f %n", account.getBalance());
    }

    private void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to deposit: Rs.");
        double amount = scanner.nextDouble();
        scanner.close();
        if(account.deposit(amount)){
            System.out.printf("Deposit successful. Your current balance is: Rs %.2f %n",account.getBalance());
        }
        else{
            System.out.println("Invalid deposit amount.");
        }
    }

    private void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: Rs.");
        double amount = scanner.nextDouble();
        scanner.close();
        if (account.withdraw(amount)) {
            System.out.printf("Withdrawal successful. Your current balance is: Rs %.2f %n",account.getBalance());
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }

}

public class Code {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(5000);
        ATM atm = new ATM(account);
        atm.displayMenu();
    }
}