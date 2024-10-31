import java.util.Scanner;

class BankAccount {
    Scanner scan = new Scanner(System.in);
    String name;
    int account_number;
    String type_of_account;
    double balance;

    public BankAccount(String name, int account_number, String type_of_account, double balance) {
        this.name = name;
        this.account_number = account_number;
        this.type_of_account = type_of_account;
        this.balance = balance;
    }

    void deposit() {
        System.out.println("enter the amount you want to deposit");
        double d = scan.nextDouble();
        if (d > 0) {
            balance += d;
            System.out.println("Current deposit is :" + balance);
        }
    }

    void withdraw() {
        System.out.println("Enter the amount you want to withdraw");
        double w = scan.nextDouble();
        if (w < 0 || w > balance) {
            System.out.println("Sorry not sufficient amount to withdraw");
        } else {
            balance -= w;
            System.out.println("the amount balance in your account is " + balance);
        }
    }

    void display() {
        System.out.println("the name of the account holder :" + name);
        System.out.println("The balance amount in the account is :" + balance);
    }
}

public class BankAccountDetails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your name");
        String name = scanner.next();
        System.out.println("enter the account number");
        int account_number = scanner.nextInt();
        System.out.println("enter the type of the account");
        String type_of_account = scanner.next();
        System.out.println("enter the initial amount in the account");
        double balance = scanner.nextDouble();
        BankAccount bank = new BankAccount(name, account_number, type_of_account, balance);
        
        System.out.println("enter the operation you want to get done");
        System.out.println("1.Deposit 2.Withdraw 3.Display 4.exit");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                bank.deposit();
                break;
            case 2:
                bank.withdraw();
                break;
            case 3:
                bank.display();
                break;
            case 4:
                System.out.println("exiting.....");
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }
}
